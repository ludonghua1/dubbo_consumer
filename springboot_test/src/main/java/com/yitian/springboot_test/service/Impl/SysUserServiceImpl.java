package com.yitian.springboot_test.service.Impl;

import com.yitian.springboot_test.dao.SysUserMapper;
import com.yitian.springboot_test.model.SysUser;
import com.yitian.springboot_test.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Transactional
    @Override
    public SysUser findUserById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
