package com.chen.module.inceptor;

import com.chen.logic.entity.UserInfo;
import com.chen.module.entity.Guest;
import com.chen.module.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 客户端入站通道拦截器
 * @author 陈梓平
 * @date 2017/10/26.
 */
public class InboundChannelInceptor extends ChannelInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(InboundChannelInceptor.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private RedisUtils redisUtils;
    /**
     * 接收前
     * @param channel
     * @return
     */
    @Override
    public boolean preReceive(MessageChannel channel) {
        log.info("preReceive...");
        return super.preReceive(channel);
    }

    /**
     * 发送前
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        // Stomp协议头部抓包
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(message);
        // Stomp协议命令
        StompCommand command = wrap.getCommand();
        //检测用户订阅内容（防止用户订阅不合法频道）
        if (StompCommand.SUBSCRIBE.equals(command)) {
            //从数据库获取用户订阅频道进行对比(这里为了演示直接使用set集合代替)
            Set<String> subedChannelInDB = new HashSet<>();
            subedChannelInDB.add("/topic/group");
            subedChannelInDB.add("/topic/online_user");
            if (subedChannelInDB.contains(wrap.getDestination())) {
                //该用户订阅的频道合法
                return super.preSend(message, channel);
            } else {
                //该用户订阅的频道不合法直接返回null前端用户就接受不到该频道信息。
                return null;
            }
        } else {
            return super.preSend(message, channel);
        }
    }

    /**
     * 完成发送后
     * @param message
     * @param channel
     * @param sent
     * @param ex
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        //检测用户是否连接成功，搜集在线的用户信息如果数据量过大我们可以选择使用缓存数据库比如redis,
        //这里由于需要频繁的删除和增加集合内容，我们选择set集合来存储在线用户
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        StompCommand command = accessor.getCommand();
        log.info("命令="+command);
        if (StompCommand.CONNECT.equals(command)){
            Map<String,UserInfo> map = (Map<String,UserInfo>) accessor.getHeader("simpSessionAttributes");
            UserInfo user = map.get("user");

            if(user != null){
                redisUtils.pushOnlineUser(user);
                Guest guest = new Guest();
                guest.setUserInfo(user);
                guest.setAccessTime(Calendar.getInstance().getTimeInMillis());
                redisUtils.pushGuestHistory(guest);
                //通过websocket实时返回在线人数
                simpMessagingTemplate.convertAndSend("/topic/online_user",redisUtils.getAllUserOnline());
            }
        }
        //如果用户断开连接，删除用户信息
        if (StompCommand.DISCONNECT.equals(command)){
            Map<String,UserInfo> map = (Map<String, UserInfo>) accessor.getHeader("simpSessionAttributes");
            UserInfo user = map.get("user");
            if (user != null){
                redisUtils.popOnlineUser(user);
                simpMessagingTemplate.convertAndSend("/topic/online_user",redisUtils.getAllUserOnline());
            }
        }
        super.afterSendCompletion(message, channel, sent, ex);
    }
}
