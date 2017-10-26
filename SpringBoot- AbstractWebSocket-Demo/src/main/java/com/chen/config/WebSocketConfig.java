package com.chen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置WebSocket
 * @author 陈梓平
 * @date 2017/10/26.
 */

@Configuration
//注解用于开启使用STOMP协议来传输基于代理（MessageBroker）的消息
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic","/user");//服务器发送给客户端的前缀
        //registry.setApplicationDestinationPrefixes("/app");//设置客户端发送给服务器的前缀
       // registry.setUserDestinationPrefix("/user/");//用户目标的前缀
    }

    /**
     *注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //通过/app/clientLink来发送消息到服务端。
        //添加访问域名限制可以防止跨域socket连接
        stompEndpointRegistry.addEndpoint("/clientLink").withSockJS();
    }
}
