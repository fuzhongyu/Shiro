package com.fzy.modules.dao;

import com.fzy.modules.entity.Permission;

import java.util.List;

/**
 * 权限
 * Created by fuzhongyu on 2017/9/7.
 */
public interface PermissionDao {

    List<Permission> findList(Permission permission);

    Permission get(String id);

}
