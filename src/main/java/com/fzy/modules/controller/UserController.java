package com.fzy.modules.controller;

import com.fzy.modules.entity.User;
import com.fzy.modules.service.UserService;
import com.fzy.modules.utils.ErrMsg;
import com.fzy.modules.utils.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fuzhongyu on 2017/9/7.
 */
@RestController
@RequestMapping(value = "${managerPath}/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("user:view")
    @RequestMapping(value = "findList")
    public ResponseResult findList(@RequestBody User user){

        System.out.println("测试查看权限");
        return new ResponseResult(ErrMsg.SUCC_1);
    }

    @RequiresPermissions("user:edit")
    @RequestMapping(value = "update")
    public ResponseResult update(@RequestBody User user){
        System.out.println("查看更改权限");
        return new ResponseResult(ErrMsg.SUCC_1);
    }


}
