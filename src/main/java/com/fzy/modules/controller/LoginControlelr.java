package com.fzy.modules.controller;

import com.fzy.modules.entity.User;
import com.fzy.modules.utils.ErrMsg;
import com.fzy.modules.utils.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fuzhongyu on 2017/9/7.
 */
@Controller
@RequestMapping(value = "${managerPath}/login")
public class LoginControlelr {

    /**
     * 提交登录信息
     * @param user
     */
    @ResponseBody
    @RequestMapping(value = "/submitLogin")
    public ResponseResult login(@RequestBody User user){
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),user.getPassword());
        token.setRememberMe(true);
        SecurityUtils.getSubject().login(token);
        return new ResponseResult(ErrMsg.SUCC_1,"登录成功");

    }


    /**
     * 登出
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/out")
    public ResponseResult out(@RequestBody User user){
//        SecurityUtils.getSubject().logout();
        return new ResponseResult(ErrMsg.SUCC_1,"登出成功");
    }

}
