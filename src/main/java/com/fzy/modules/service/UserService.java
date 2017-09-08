package com.fzy.modules.service;

import com.fzy.modules.dao.UserDao;
import com.fzy.modules.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

/**
 * 用户Service
 * Created by fuzhongyu on 2017/9/7.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 登录检验
     * @param userName
     * @param password
     * @return
     */
    public User getByNameAndPwd(String userName,String password){
        User user=userDao.getByName(userName);
        if(user!=null&&user.getPassword().equals(password)){
            return user;
        }
        return null;

    }


    public List<User> findList(User user){
        return userDao.findList(user);
    }


}
