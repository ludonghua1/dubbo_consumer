package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.User;
import com.yitian.ldh.vo.LoginVo;

import java.util.List;

public interface UserMapper extends BaseDao<User> {

    User findUserByUsernameAndPassword(LoginVo loginVo);

    User findUserByLoginNameAndEmail(LoginVo vo);

    User findUserByUser(String loginName);

    User findUserByPhone(String telnum);

    User findUserByEmail(String email);

    List<User> findStaff(User user);
}