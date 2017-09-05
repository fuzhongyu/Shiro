package com.fzy.modules.entity;

/**
 * 角色实体类
 * Created by fuzhongyu on 2017/9/5.
 */
public class Role {

    private Long id;

    private String name;   //角色名称

    private String type;  //角色类型

    private String deleteFlag;  //删除标记， 0-正常，1-删除

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
