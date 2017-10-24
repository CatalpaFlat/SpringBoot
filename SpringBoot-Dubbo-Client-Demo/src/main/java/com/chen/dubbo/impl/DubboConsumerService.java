package com.chen.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chen.dubbo.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *  Dubbo 服务消费者
 * @author 陈梓平
 * @date 2017/10/17.
 */
@Service("refService")
public class DubboConsumerService {
    @Reference(group="helloService", version="1.0")
    DubboService dubboService;

    public String get(String str) {
        if (dubboService!=null){
            Object cityByName = dubboService.findCityByName(str);
            return cityByName.toString();
        }
        return null;
    }
}
