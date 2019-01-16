package com.yitian.springboot_test.service;

import com.yitian.springboot_test.model.SysUser;

public interface SysUserService {

    SysUser findUserById(Integer id);
}
