package com.chen.elasticsearch.bean;

import java.io.Serializable;

/**
 * 文章
 * @author 陈梓平
 * @date 2017/10/19.
 */
public class Author implements Serializable {
    private long id;//作者id
    private String name;//作者姓名
    private String remark;//作者简介

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
