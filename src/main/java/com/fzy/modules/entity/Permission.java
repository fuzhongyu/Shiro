package com.fzy.modules.entity;

import java.io.Serializable;

/**
 * 权限
 * Created by fuzhongyu on 2017/9/7.
 */
public class Permission implements Serializable{

    private static final long serialVersionUID=1L;

    private String id;

    private String permiss;   //权限

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermiss() {
        return permiss;
    }

    public void setPermiss(String permiss) {
        this.permiss = permiss;
    }
}
