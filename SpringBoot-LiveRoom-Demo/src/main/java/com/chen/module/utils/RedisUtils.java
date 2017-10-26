package com.chen.module.utils;

import com.chen.logic.entity.UserInfo;
import com.chen.module.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */
@Repository
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    public void pushOnlineUser(UserInfo userEntity){
        redisTemplate.opsForSet().add("OnlineUser",userEntity);
    }
    public void pushGuestHistory(Guest guest){
        //最多存储指定个数的访客
        if (redisTemplate.opsForList().size("Guest") == 2000l){
            redisTemplate.opsForList().rightPop("Guest");
        }
        redisTemplate.opsForList().leftPush("Guest",guest);
    }
    public Set getAllUserOnline(){
        return redisTemplate.opsForSet().members("OnlineUser");
    }
    public void popOnlineUser(UserInfo userEntity){
        redisTemplate.opsForSet().remove("OnlineUser" ,userEntity);
    }
}
