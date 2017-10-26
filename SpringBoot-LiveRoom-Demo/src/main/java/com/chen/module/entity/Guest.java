package com.chen.module.entity;

import com.chen.logic.entity.UserInfo;

import java.io.Serializable;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */
public class Guest implements Serializable{

    private UserInfo userInfo;
    private long accessTime;//存取时间

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(long accessTime) {
        this.accessTime = accessTime;
    }
}
