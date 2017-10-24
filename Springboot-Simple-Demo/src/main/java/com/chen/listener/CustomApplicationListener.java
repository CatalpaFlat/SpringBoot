package com.chen.listener;

import com.chen.listener.event.CustomApplicationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 * @author 陈梓平
 * @date 2017/10/13.
 */
//第二种实现方法，基于第一种实现方法
//加上@Component注解，纳入spring容器管理
//@Component
public class CustomApplicationListener implements ApplicationListener<CustomApplicationEvent>{

    private static final Logger log = LoggerFactory.getLogger(CustomApplicationListener.class);
    @Override
    public void onApplicationEvent(CustomApplicationEvent event) {
        log.info("接收到的的事件类型："+event.getClass());
    }
}
