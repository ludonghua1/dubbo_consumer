package com.yitian.ldh.dao;

import com.yitian.ldh.model.RoleMenu;

public interface RoleMenuMapper {
    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);
}