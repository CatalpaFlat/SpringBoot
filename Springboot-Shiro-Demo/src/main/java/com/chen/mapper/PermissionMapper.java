package com.chen.mapper;

import com.chen.common.mapper.BaseMapper;
import com.chen.entity.PermissionInfo;
import com.chen.entity.UserInfo;

import java.util.List;

/**
 * Created by 陈梓平 on 2017/9/18.
 */

public interface PermissionMapper  extends BaseMapper<UserInfo, Long> {
    /**
     * 根据用户id获取用户权限
     * @param id
     */
    List<PermissionInfo> queryPermissionByUid(Long id);
}
