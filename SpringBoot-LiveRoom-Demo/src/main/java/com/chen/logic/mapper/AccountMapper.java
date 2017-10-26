package com.chen.logic.mapper;

import com.chen.logic.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 陈梓平
 * @date 2017/10/26.
 */
public interface AccountMapper {
    String queryIsUserByNameAndPass(@Param(value = "name")String name,
                                    @Param(value = "password")String password);

    int insertUser(UserInfo accUserInfo);
}
