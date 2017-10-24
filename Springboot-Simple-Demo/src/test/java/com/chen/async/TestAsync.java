package com.chen.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 测试异步线程
 * @author 陈梓平
 * @date 2017/10/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAsync {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void AsyncTaskTest() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
    }
}
