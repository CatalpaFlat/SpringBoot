package com.chen.schedule;

import com.chen.async.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 陈梓平
 * @date 2017/10/16.
 */
//@Component
public class TestSerialSchedule {
    private static final Logger logger = LoggerFactory.getLogger(TestSerialSchedule.class);

    @Autowired
    private AsyncTask asyncTask;
//    @Scheduled(cron="0 0/1 * * * ?")
    public void executeFileDownLoadTask() throws Exception {

        // 间隔2分钟,执行任务
        Thread current = Thread.currentThread();
        long l = System.currentTimeMillis();
        asyncTask.doTaskOne();
        logger.info("当前时间:"+l );
        logger.info("定时任务1:"+current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
        asyncTask.doTaskTwo();
    }
}
