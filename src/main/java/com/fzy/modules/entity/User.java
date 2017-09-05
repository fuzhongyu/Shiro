package com.fzy.modules.entity;

import java.util.List;

/**
 * 用户实体类
 * Created by fuzhongyu on 2017/9/4.
 */
public class User {

    private long id;

    private String userName;  //用户名

    private String password;  //密码

    private Short age;  //年龄

    private String deleteFlag;  //删除标记  0-正常，1-删除

    private List<Role> roleList;  //角色列表

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
