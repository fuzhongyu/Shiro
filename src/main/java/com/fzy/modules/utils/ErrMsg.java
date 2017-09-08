package com.fzy.modules.utils;

/**
 * Created by fuzhongyu on 2017/9/7.
 */
public enum ErrMsg {

    /**
     * 系统错误码
     */
    SUCC_1("1","操作成功"),
    ERR_9999("9999","操作异常"),

    ERR_1001("1001","用户名或密码错误");


    private String code; //相应状态码
    private String msg;  //响应吗说明

    ErrMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}