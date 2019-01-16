package com.yitian.ldh.service;


import com.yitian.ldh.model.Menu;
import com.yitian.ldh.model.Role;
import com.yitian.ldh.model.User;
import com.yitian.ldh.vo.LoginVo;
import com.yitian.ldh.vo.RegisterVo;

import java.util.List;

public interface UserService {
    User findUserByUsernameAndPassword(LoginVo loginVo);

    List<Menu> findMenuByUser(User user);

    User findUserByLoginNameAndEmail(LoginVo vo);

    void updateUser(User user);

    void updateUserByPassword(User user);

    void addRegister(RegisterVo vo);

    User findUserByUser(String loginName);

    User findUserByPhone(String telnum);

    User findUserByEmail(String email);

    List<Role> loadUserRoles(Integer id);

    List<User> findStaff(User user);
}
