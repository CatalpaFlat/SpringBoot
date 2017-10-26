package com.chen.entity;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 信息类
 * @author 陈梓平
 * @date 2017/10/26.
 */
public class MsgInfo implements Serializable{
    private String creator;
    private String msgBody;
    private Calendar sTime;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public Calendar getsTime() {
        return sTime;
    }

    public void setsTime(Calendar sTime) {
        this.sTime = sTime;
    }
}
