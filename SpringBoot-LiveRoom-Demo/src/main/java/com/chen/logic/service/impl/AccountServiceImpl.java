package com.chen.logic.service.impl;

import com.chen.logic.entity.UserInfo;
import com.chen.logic.mapper.AccountMapper;
import com.chen.logic.service.AccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author 陈梓平
 * @date 2017/10/26.
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;
    @Resource
    private UserInfo accUserInfo;
    @Override
    public String queryIsUserByNameAndPass(String name, String password, HttpSession session) {
        String s = accountMapper.queryIsUserByNameAndPass(name, password);
        if (StringUtils.isBlank(s)) {
            return "";
        }else {
            String id = session.getId();
            session.setAttribute(id,s);
            return "0";
        }
    }

    @Override
    public int regist(String name, String password) {
        String ip = UUID.randomUUID().toString();
        accUserInfo.setIp(ip);
        accUserInfo.setName(name);
        accUserInfo.setPassword(password);
        return accountMapper.insertUser(accUserInfo);
    }
}
