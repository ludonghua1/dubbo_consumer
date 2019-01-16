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

    @Override
    public SysUser findUser(SysUser user) {
        return sysUserMapper.findUser(user);
    }

    @Override
    public void insertUser(SysUser user) {
        sysUserMapper.insertSelective(user);
    }

    @Override
    public SysUser findByUser(String loginName) {
        return sysUserMapper.findByUser(loginName);
    }


}
