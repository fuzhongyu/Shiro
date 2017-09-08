package com.fzy.modules.dao;

import com.fzy.modules.entity.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by fuzhongyu on 2017/9/5.
 */
public interface RoleDao {

    List<Role> findList(Role role);

    Role get(Long id);

    Set<Role> findRoleByUser(String userId);
}
