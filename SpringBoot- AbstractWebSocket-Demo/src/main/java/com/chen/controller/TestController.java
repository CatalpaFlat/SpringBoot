package com.chen.controller;

import com.chen.entity.MsgInfo;
import com.chen.entity.SendInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;

/**
 * Controller测试
 * @author 陈梓平
 * @date 2017/10/26.
 */
@Controller
@RequestMapping
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/send1")
    @SendTo("/topic/msgInfo")
    public MsgInfo msgInfo(String msg,String name){
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setCreator(name);
        msgInfo.setMsgBody(msg);
        msgInfo.setsTime(Calendar.getInstance());
        log.info("msgInfo");
        return msgInfo;
    }


    @GetMapping(value = "ws")
    public String ws(){
        return "ws";
    }

    /**
     * 测试对指定用户发送消息方法
     * @return
     */
    @MessageMapping("/send")
    public void send(SendInfo sendInfo) {
        simpMessageSendingOperations.convertAndSendToUser(sendInfo.getHid(), "/message", sendInfo.getMsg());
    }
}
