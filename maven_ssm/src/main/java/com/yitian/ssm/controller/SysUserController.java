package com.yitian.ssm.controller;

import com.yitian.ssm.model.SysUser;
import com.yitian.ssm.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @RequestMapping("test.")
    public String test(int id, HttpServletRequest request){
        SysUser user = sysUserService.findUserById(id);
        request.setAttribute("user",user);
        return "test";
    }

}
