package com.chen.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * 应用程序启动后首先被调用
 * @author 陈梓平
 * @date 2017/10/13.
 */
public class StartRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartRunner.class);

    /**
     * 对于那种只需要在应用程序启动时执行一次的任务，非常适合利用Command line runners来完成
     * 利用command-line runner的这个特性，再配合依赖注入，可以在应用程序启动时后首先引入一些依赖bean，
     * 例如data source、rpc服务或者其他模块等等，这些对象的初始化可以放在run方法中。
     * 不过，需要注意的是，在run方法中执行初始化动作的时候一旦遇到任何异常，都会使得应用程序停止运行，
     * 因此最好利用try/catch语句处理可能遇到的异常。
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        log.info("StartRunner is run!");
    }
}
