package com.yitian.ssm.service;

import com.yitian.ssm.model.SysUser;

public interface SysUserService {
    public SysUser findUserById(int id);
    public SysUser findUser(SysUser user);
    public void insertUser(SysUser user);
    SysUser findByUser(String loginName);
}
