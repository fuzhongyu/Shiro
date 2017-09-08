package com.fzy.modules.service;

import com.fzy.modules.dao.RoleDao;
import com.fzy.modules.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色serive
 * Created by fuzhongyu on 2017/9/7.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;


    public Set<Role> findRoleByUser(String userId){
        return roleDao.findRoleByUser(userId);
    }




}
