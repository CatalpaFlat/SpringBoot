package com.chen.enable.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 陈梓平
 * @date 2017/10/16.
 */
@ConfigurationProperties(prefix = "pojotopro")
public class POJOToProperties {
    private String name;
    private String pass;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
