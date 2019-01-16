package com.yitian.ssm.service.imp;

import com.yitian.ssm.dao.SysUserMapper;
import com.yitian.ssm.model.SysUser;
import com.yitian.ssm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserById(int id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
