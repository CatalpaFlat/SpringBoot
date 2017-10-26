package com.chen.logic.controller;

import com.chen.logic.entity.UserInfo;
import com.chen.module.entity.MsgEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Map;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */
@RestController
@RequestMapping
public class SendController {
    private static final Logger log = LoggerFactory.getLogger(SendController.class);
    @PostMapping(value = "/send")
    public String send(@RequestParam String value){
        log.info("value:"+value);
        return "value:"+value;
    }
    @MessageMapping(value = "/chat")
    @SendTo("/topic/group")
    public MsgEntity testWst(String message ,
                             @Header(value = "simpSessionAttributes") Map<String,Object> session){
        UserInfo user = (UserInfo) session.get("user");
        String username = user.getName();
        MsgEntity msg = new MsgEntity();
        msg.setCreator(username);
        msg.setsTime(Calendar.getInstance());
        msg.setMsgBody(message);
        return msg;
    }
}
