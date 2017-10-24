package com.chen.entity;

import java.io.Serializable;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public class PermissionInfo implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID =1493049839167L;

    private Long id;//
    private String url;//url地址
    private String name;//url描述

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
