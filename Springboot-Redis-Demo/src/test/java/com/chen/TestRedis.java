package com.chen;

import com.chen.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by 陈梓平 on 2017/9/20.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    private Logger logger = LoggerFactory.getLogger(TestRedis.class);

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "陈梓平");
        logger.info("value："+stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user=new User("陈梓平", "123456");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("com", user);
//        operations.set("com.chen", user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.chen");
//        boolean exists=redisTemplate.hasKey("com.chen");
        boolean exists=redisTemplate.hasKey("com");
        if(exists){
            logger.info("exists is true");
//            Object com = redisTemplate.opsForValue().get("com");
//            logger.info("com:"+com);
            User u = (User)redisTemplate.opsForValue().get("com");
            String username = u.getUsername();
            logger.info("username:"+username);
        }else{
            logger.info("exists is false");
        }
    }


}
