package com.chen.metrics.lifecycle;

import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 陈梓平
 * @date 2017/10/16.
 */
@Component
public class MockService {
    private static  final Logger log = LoggerFactory.getLogger(MockService.class);
    @Timed
    @Counted
    public void doSth(){
        log.info("just to do something.");
    }
}
