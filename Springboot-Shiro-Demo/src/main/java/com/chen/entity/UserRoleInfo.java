package com.chen.entity;

import java.io.Serializable;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public class UserRoleInfo implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID =1493049839167L;

    private Long uid;//用户ID
    private Long rid;//角色ID

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}
