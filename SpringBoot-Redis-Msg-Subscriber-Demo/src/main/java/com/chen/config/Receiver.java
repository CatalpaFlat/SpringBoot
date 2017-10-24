package com.chen.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Redis消息的接收者
 * @author 陈梓平
 * @date 2017/10/24.
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    /**
     * 计数器，用来控制线程
     */
    private CountDownLatch latch;

    /**
     * 注册为一个消息监听者
     * @param latch
     */
    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * 接收信息
     * @param message
     */
    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();//当前线程调用此方法，则计数减一
    }

}
