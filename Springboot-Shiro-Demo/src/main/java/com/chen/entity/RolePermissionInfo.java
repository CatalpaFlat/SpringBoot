package com.chen.entity;

import java.io.Serializable;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public class RolePermissionInfo implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID =1493049839167L;

    private Long rid;//角色ID
    private Long pid;//权限ID

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
