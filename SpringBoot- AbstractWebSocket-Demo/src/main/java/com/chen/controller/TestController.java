package com.chen.controller;

import com.chen.entity.MsgInfo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

/**
 * Controller测试
 * @author 陈梓平
 * @date 2017/10/26.
 */
@Controller
@RequestMapping
public class TestController {
    @MessageMapping("/send")
    @SendTo("/topic/msgInfo")
    public MsgInfo msgInfo(String msg,String name){
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setCreator(name);
        msgInfo.setMsgBody(msg);
        msgInfo.setsTime(Calendar.getInstance());
        return msgInfo;
    }
    @GetMapping(value = "ws")
    public String ws(){
        return "ws";
    }


}
