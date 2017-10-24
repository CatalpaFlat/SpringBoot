package com.chen.entity;

import java.io.Serializable;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public class RoleInfo implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID =1493049839167L;

    private Long id;//
    private String name;//角色名称
    private String type;//角色类型

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
