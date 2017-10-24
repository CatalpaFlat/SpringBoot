package com.chen.elasticsearch.bean;

import java.io.Serializable;

/**
 * 教程
 * @author 陈梓平
 * @date 2017/10/19.
 */
public class Tutorial implements Serializable {
    private long id;
    private String name;//教程名称

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
