package com.chen.service;

import com.chen.entity.UserInfo;

import java.util.Map;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public interface AdminService {
    String indexCheck(UserInfo user);

    Map<String,Object> submitLogin(String username, String password);
}
