package com.chen.dubbo.impl;

import com.chen.dubbo.DubboService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Dubbo 服务层实现层
 * @author 陈梓平
 * @date 2017/10/17.
 */
@Service(group="helloService", version="1.0")
public class DubboServiceImpl implements DubboService {
    @Override
    public Object findCityByName(String cityName) {
        return "so goods";
    }
}
