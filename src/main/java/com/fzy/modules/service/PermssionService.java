package com.fzy.modules.service;

import com.fzy.modules.dao.PermissionDao;
import com.fzy.modules.dao.UserDao;
import com.fzy.modules.entity.Permission;
import com.fzy.modules.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限Service
 * Created by fuzhongyu on 2017/9/7.
 */
@Service
public class PermssionService {

    @Autowired
    private PermissionDao permissionDao;

    public List<Permission> findList(Permission permission){
        return permissionDao.findList(permission);
    }

    public Permission get(String id){
        return permissionDao.get(id);
    }


}
