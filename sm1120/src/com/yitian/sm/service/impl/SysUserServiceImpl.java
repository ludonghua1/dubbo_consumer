package com.yitian.sm.service.impl;

import com.yitian.sm.mapper.SysUserMapper;
import com.yitian.sm.model.SysUser;
import com.yitian.sm.service.SysUserService;
import com.yitian.sm.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class SysUserServiceImpl implements SysUserService {

    @Override
    public SysUser findSysUserAndPassword(SysUser user) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        SysUserMapper sm = session.getMapper(SysUserMapper.class);
        return sm.findSysUserAndPassword(user);
    }

    @Override
    public SysUser findSysUserById(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        SysUserMapper sm = session.getMapper(SysUserMapper.class);
        return sm.selectByPrimaryKey(id);
    }
}
