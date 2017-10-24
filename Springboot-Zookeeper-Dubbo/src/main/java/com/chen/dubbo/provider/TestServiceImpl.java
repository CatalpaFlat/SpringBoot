package com.chen.dubbo.provider;

import com.chen.dubbo.remote.TestService;

/**
 * @author 陈梓平
 * @date 2017/10/11.
 */
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
