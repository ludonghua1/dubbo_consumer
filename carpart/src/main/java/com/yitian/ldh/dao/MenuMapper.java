package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Menu;
import com.yitian.ldh.model.User;

import java.util.List;

public interface MenuMapper extends BaseDao<Menu> {

    List<Menu> findMenuByUser(User user);

    List<Menu> findAllMenu();

}