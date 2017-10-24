package com.chen.logic.service.impl;

import com.chen.logic.service.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 业务发布层
 * @author 陈梓平
 * @date 2017/10/24.
 */
@Service
public class PublisherServiceImpl implements PublisherService {
    private static final Logger log = LoggerFactory.getLogger(PublisherServiceImpl.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String pubMsg(String id) {
        if ("1".equals(id)){
            stringRedisTemplate.convertAndSend("phone","18888888888");
            log.info("Publisher sendes Topic... ");
            return "success";
        }else {
            return "no my phone";
        }
    }
}
