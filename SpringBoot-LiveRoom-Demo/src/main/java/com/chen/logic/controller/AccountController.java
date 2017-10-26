package com.chen.logic.controller;

import com.chen.logic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */
@RestController
@RequestMapping(value = "/acc")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping(value = "/login")
    public String login(@RequestParam String name, @RequestParam String password, HttpSession session){
        return accountService.queryIsUserByNameAndPass(name,password,session);
    }
    @PostMapping(value = "/regist")
    public int regist(@RequestParam String name,@RequestParam String password){
        return accountService.regist(name,password);
    }
}
