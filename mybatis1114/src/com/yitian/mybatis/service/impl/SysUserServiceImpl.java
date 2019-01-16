package com.yitian.mybatis.service.impl;

import com.yitian.mybatis.mapper.SysUserMapper;
import com.yitian.mybatis.model.SysUser;
import com.yitian.mybatis.service.SysUserService;
import com.yitian.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class SysUserServiceImpl implements SysUserService {
    @Override
    public SysUser findUserById(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        SysUserMapper sm = session.getMapper(SysUserMapper.class);
        SysUser user = sm.selectByPrimaryKey(id);
        session.close();
        return  user;
    }
}
