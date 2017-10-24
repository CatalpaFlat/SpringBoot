package com.chen.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步任务
 * @author 陈梓平
 * @date 2017/10/16.
 */
@Component
public class AsyncTask {
    private static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);
    @Async
    public void doTaskOne() throws Exception {
        logger.info("doTaskOne");
    }
    @Async
    public void doTaskTwo() throws Exception {
        logger.info("doTaskTwo");
    }
    @Async
    public void doTaskThree() throws Exception {
        logger.info("doTaskThree");
    }
    @Async
    public void doTaskFour() throws Exception {
        logger.info("doTaskFour");
    }

}
