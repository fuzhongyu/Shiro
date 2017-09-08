package com.fzy.modules.dao;

import com.fzy.modules.entity.Role;
import com.fzy.modules.entity.User;

import java.util.List;

/**
 * Created by fuzhongyu on 2017/9/5.
 */
public interface UserDao {

    List<User> findList(User user);

    User get(Long id);

    User getByName(String userName);
}
