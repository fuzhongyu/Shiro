package com.fzy.modules.utils;

/**
 * 异常类
 * Created by fuzhongyu on 2017/9/7.
 */
public class ServiceException extends RuntimeException {

    private String code;

    private String msg;


    public ServiceException(ErrMsg errMsg){
        this.code=errMsg.getCode();
        this.msg=errMsg.getMsg();
    }

    public ServiceException(ErrMsg errMsg,String msg){
        this.code=errMsg.getCode();
        if(msg!=null){
            this.msg=msg;
        }else {
            this.msg=errMsg.getMsg();
        }

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
