package com.fzy.modules.controller;

import com.fzy.modules.entity.Permission;
import com.fzy.modules.service.PermssionService;
import com.fzy.modules.utils.ErrMsg;
import com.fzy.modules.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fuzhongyu on 2017/9/7.
 */
@Controller
@RequestMapping("${managerPath}/permission")
public class PermissionController {

    @Autowired
    private PermssionService permssionService;

    @ResponseBody
    @RequestMapping("list")
    public ResponseResult findList(Permission permission){
        List<Permission> list=permssionService.findList(permission);
        return new ResponseResult(ErrMsg.SUCC_1,list);
    }

}
