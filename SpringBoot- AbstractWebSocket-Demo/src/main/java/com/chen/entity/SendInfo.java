package com.chen.entity;

import java.io.Serializable;

/**
 * @author 陈梓平
 * @date 2017/10/27.
 */
public class SendInfo implements Serializable {
    private String hid;
    private String msg;

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
