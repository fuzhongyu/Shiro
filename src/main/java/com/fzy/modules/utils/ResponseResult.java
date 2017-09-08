package com.fzy.modules.utils;

/**
 * 返回结果类
 * Created by fuzhongyu on 2017/9/7.
 */
public class ResponseResult {

    private String code;

    private String msg;

    private Object result;




    public ResponseResult(ErrMsg errMsg) {
       this(errMsg,null);
    }


    public ResponseResult(ErrMsg errMsg,Object result){
       this(errMsg.getCode(),errMsg.getMsg(),result);
    }

    public ResponseResult(String code,String msg,Object result){
        this.code=code;
        this.msg=msg;
        this.result=result;
    }

}
