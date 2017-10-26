package com.chen.controller;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JumpController {
    @GetMapping(value = "login")
    public String login(){
        return "login";
    }
    @GetMapping(value = "regist")
    public String regist(){
        return "regist";
    }
    @GetMapping(value = "list")
    public String list(){
        return "list";
    }
    @GetMapping(value = "room")
    public String room(){
        return "room";
    }
}
