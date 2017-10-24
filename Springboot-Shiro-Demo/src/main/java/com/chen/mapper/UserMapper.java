package com.chen.mapper;

import com.chen.common.mapper.BaseMapper;
import com.chen.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public interface UserMapper {
     UserInfo queryByName(@Param("name") String name);
}
