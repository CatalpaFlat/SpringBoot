package com.chen.logic.service;

import javax.servlet.http.HttpSession;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */
public interface AccountService {
    String queryIsUserByNameAndPass(String name, String password, HttpSession session);

    int regist(String name, String password);
}
