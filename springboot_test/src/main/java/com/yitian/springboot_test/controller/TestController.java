package com.yitian.springboot_test.controller;


import com.yitian.springboot_test.model.SysUser;
import com.yitian.springboot_test.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class TestController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/test")
    public SysUser test(Integer id) throws IOException {
        SysUser sysUser = sysUserService.findUserById(id);
        return sysUser;
    }
}
