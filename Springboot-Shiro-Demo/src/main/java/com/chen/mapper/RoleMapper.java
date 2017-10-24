package com.chen.mapper;

import com.chen.common.mapper.BaseMapper;
import com.chen.entity.RoleInfo;
import com.chen.entity.UserInfo;

import java.util.List;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public interface RoleMapper extends BaseMapper<UserInfo, Long> {

    /**
     * 根据用户ID获取该用户所在组的角色权限
     * @param obj
     */
    public List<RoleInfo> queryRoleByUid(Long obj);
}
