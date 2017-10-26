package com.chen.logic.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */
@Component
public class UserInfo implements Serializable {
    private String ip;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "UserInfo{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
