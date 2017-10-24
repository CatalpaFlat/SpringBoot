package com.chen.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author 陈梓平
 * @date 2017/10/13.
 */
public class CustomApplicationEvent extends ApplicationEvent {
    public CustomApplicationEvent(Object source) {
        super(source);
    }
}
