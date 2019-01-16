package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Role;

import java.util.List;

public interface RoleMapper extends BaseDao<Role> {

    List<Role> loadUserRoles(Integer id);
}