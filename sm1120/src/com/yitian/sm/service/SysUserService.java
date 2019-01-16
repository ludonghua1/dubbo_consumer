package com.yitian.sm.service;

import com.yitian.sm.model.SysUser;

public interface SysUserService {
    public SysUser findSysUserAndPassword(SysUser user);

    public SysUser findSysUserById(int id);

}
