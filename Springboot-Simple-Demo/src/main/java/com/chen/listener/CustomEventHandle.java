package com.chen.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 第四种方法，
 * 1、自定义CustomEventHandle
 * 2、使用@EventListener注解
 * 3、并且纳入Spring容器中
 * @author 陈梓平
 * @date 2017/10/13.
 */
//@Component
public class CustomEventHandle {
    private static final Logger log = LoggerFactory.getLogger(CustomEventHandle.class);
    /**
     * 参数任意(为Object）的时候所有事件都会监听到
     * 所有，该参数事件，或者其子事件（子类）都可以接收到
     * @param event
     */
//    @EventListener
    public void event(Object event){
        log.info("MyEventHandle 接收到事件：" + event.getClass());
    }

}
