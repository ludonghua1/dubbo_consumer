package com.yitian.ssm.dao;

import com.yitian.ssm.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findUser(SysUser user);

    SysUser findByUser(String loginName);
}