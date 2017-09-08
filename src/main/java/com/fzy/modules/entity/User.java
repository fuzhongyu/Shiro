package com.fzy.modules.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 用户实体类
 * Created by fuzhongyu on 2017/9/4.
 */
public class User implements Serializable{

    private static final long serialVersionUID=1L;

    private String id;

    private String userName;  //用户名

    private String password;  //密码

    private Short age;  //年龄

    private String deleteFlag;  //删除标记  0-正常，1-删除

    private Set<Role> roleList;  //角色集合

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }
}
