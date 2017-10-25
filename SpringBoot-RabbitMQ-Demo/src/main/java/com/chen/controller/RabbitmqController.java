package com.chen.controller;

import com.chen.config.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈梓平
 * @date 2017/10/25.
 */
@RestController
@RequestMapping
public class RabbitmqController {

    @Autowired
    private Sender sender;

    @GetMapping("/send")
    public String send( String msg) {
        sender.sendMsg(msg);
        return "Send OK.";
    }
}
