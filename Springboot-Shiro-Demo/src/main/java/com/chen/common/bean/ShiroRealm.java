package com.chen.common.bean;

import com.chen.entity.PermissionInfo;
import com.chen.entity.RoleInfo;
import com.chen.entity.UserInfo;
import com.chen.mapper.PermissionMapper;
import com.chen.mapper.RoleMapper;
import com.chen.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户的角色和权限信息
 * Created by 陈梓平 on 2017/9/14.
 */
public class ShiroRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("开启验证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("验证当前Subject时获取到token为：" + token.toString());
        String username = token.getUsername();
        //查出是否有此用户
        UserInfo userInfo = userMapper.queryByName(username);
        if (userInfo != null){
            Long id = userInfo.getId();
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<RoleInfo> roleInfos = roleMapper.queryRoleByUid(id);//获取用户角色
            List<PermissionInfo> permissionInfos = permissionMapper.queryPermissionByUid(id);//获取用户权限
            List<String> roleStrlist=new ArrayList<String>();//用户的角色集合
            List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合
            for (RoleInfo role : roleInfos) {
                roleStrlist.add(role.getName());
            }
            for (PermissionInfo uPermission : permissionInfos) {
                perminsStrlist.add(uPermission.getName());
            }

            userInfo.setRoleStrlist(roleStrlist);
            userInfo.setPerminsStrlist(perminsStrlist);

            return new SimpleAuthenticationInfo(userInfo, userInfo.getPswd(), getName());
        }
        return null;
    }

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");

        UserInfo user = (UserInfo) principalCollection.getPrimaryPrincipal();

        if (user != null) {
            logger.info("user权限");
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleStrlist());
            //用户的权限集合
            info.addStringPermissions(user.getPerminsStrlist());

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }
}
