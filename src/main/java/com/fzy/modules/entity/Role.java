package com.fzy.modules.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * 角色实体类
 * Created by fuzhongyu on 2017/9/5.
 */
public class Role implements Serializable{

    private static final long serialVersionUID=1L;

    private String id;

    private String name;   //角色名称

    private String type;  //角色类型

    private String deleteFlag;  //删除标记， 0-正常，1-删除

    private String permissJsonStr;  //权限在数据库中已json存储

    private Set<Permission> permissionSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPermissJsonStr() {
        return permissJsonStr;
    }

    public void setPermissJsonStr(String permissJsonStr) {
        this.permissJsonStr = permissJsonStr;
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }
}
