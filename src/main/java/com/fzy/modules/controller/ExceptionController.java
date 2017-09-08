package com.fzy.modules.controller;

import com.fzy.modules.utils.ErrMsg;
import com.fzy.modules.utils.ResponseResult;
import com.fzy.modules.utils.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fuzhongyu on 2017/9/7.
 */
@ControllerAdvice
public class ExceptionController {

    private Logger logger= LoggerFactory.getLogger(ExceptionController.class);

    @ResponseBody
    @ExceptionHandler
    public ResponseResult bindException(Exception ex) {
        ResponseResult responseResult = null;
        if(ex instanceof ServiceException){
            ServiceException serviceException = (ServiceException) ex;
            if (StringUtils.isNotBlank(serviceException.getCode())){
                responseResult = new ResponseResult(serviceException.getCode(),serviceException.getMsg(),null);
            }else{
                logger.error(ex.getMessage() ,ex);
                responseResult = new ResponseResult(ErrMsg.ERR_9999);
            }
        }else{
            logger.error(ex.getMessage() ,ex);
            responseResult = new ResponseResult(ErrMsg.ERR_9999);
        }
        return responseResult;
    }
}
