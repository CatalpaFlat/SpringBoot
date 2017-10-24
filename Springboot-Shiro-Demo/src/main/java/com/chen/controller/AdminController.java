package com.chen.controller;

import com.chen.entity.UserInfo;
import com.chen.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
@Controller
@RequestMapping
public class AdminController {
    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到登录表单页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("/index")
    public String list() {
        logger.info("this is index");
        return "index";
    }
    /**
     * 主页
     * @return
     */
    @RequestMapping("/403")
    public String list403() {
        logger.info("this is 403");
        return "403";
    }
    //登陆验证，这里方便url测试，正式上线需要使用POST方式提交
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.GET)
    public String index(UserInfo user) {
        return  adminService.indexCheck(user);
    }
    /**
     * ajax登录请求接口方式登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/ajaxLogin",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitLogin(String username, String password) {
        return adminService.submitLogin(username,password);
    }
}
