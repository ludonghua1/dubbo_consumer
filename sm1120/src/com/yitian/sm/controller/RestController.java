package com.yitian.sm.controller;

import com.yitian.sm.model.SysUser;
import com.yitian.sm.service.SysUserService;
import com.yitian.sm.service.impl.SysUserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
    private SysUserService sysUserService = new SysUserServiceImpl();
    @RequestMapping("/user/{id}")
    public @ResponseBody SysUser findUserById(@PathVariable("id") int id){
        SysUser user = sysUserService.findSysUserById(id);
        return user;
    }
}
