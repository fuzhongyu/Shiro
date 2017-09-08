package com.fzy.modules.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fzy.modules.entity.Role;
import com.fzy.modules.entity.User;
import com.fzy.modules.service.RoleService;
import com.fzy.modules.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

/**
 * 认证实现  （shiro 的登录认证和授权实现）
 * Created by fuzhongyu on 2017/9/5.
 */
public class UserAuthorRealm extends AuthorizingRealm{


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        User user=userService.getByNameAndPwd(token.getUsername(),String.valueOf(token.getPassword()));
        if(user==null){
            new ServiceException(ErrMsg.ERR_1001);
        }else if("1".equals(user.getDeleteFlag())){
            new ServiceException(ErrMsg.ERR_1001,"用户已经被禁止登录");
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),user.getUserName());
    }


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user= (User) SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        //查询角色和权限
        Set<Role> roleSet=roleService.findRoleByUser(user.getId());
        //存储角色集合
        Set<String> roleTypeSet=new HashSet<>();
        //存储权限集合
        Set<String> permissSet=new HashSet<>();

        for (Role role:roleSet){
            roleTypeSet.add(role.getType());
            JSONArray jsonArray= JSON.parseArray(role.getPermissJsonStr());
            for (Object str:jsonArray){
                permissSet.add(str.toString());
            }
        }
        simpleAuthorizationInfo.setRoles(roleTypeSet);
        simpleAuthorizationInfo.setStringPermissions(permissSet);

        return simpleAuthorizationInfo;
    }


}
