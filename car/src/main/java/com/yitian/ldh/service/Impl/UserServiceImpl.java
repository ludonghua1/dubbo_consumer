package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.CompanyMapper;
import com.yitian.ldh.dao.MenuMapper;
import com.yitian.ldh.dao.RoleMapper;
import com.yitian.ldh.dao.UserMapper;
import com.yitian.ldh.model.Company;
import com.yitian.ldh.model.Menu;
import com.yitian.ldh.model.Role;
import com.yitian.ldh.model.User;
import com.yitian.ldh.service.UserService;
import com.yitian.ldh.util.SHA1Util;
import com.yitian.ldh.vo.LoginVo;
import com.yitian.ldh.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public User findUserByUsernameAndPassword(LoginVo loginVo) {
        return userMapper.findUserByUsernameAndPassword(loginVo);
    }

    @Override
    public List<Menu> findMenuByUser(User user) {
        return menuMapper.findMenuByUser(user);
    }

    @Override
    public User findUserByLoginNameAndEmail(LoginVo vo) {
        return userMapper.findUserByLoginNameAndEmail(vo);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateUserByPassword(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void addRegister(RegisterVo vo) {
        Company company = new Company();
        company.setAddress(vo.getAddress());
        company.setCity(vo.getCity());
        company.setCompanycode(UUID.randomUUID().toString());
        company.setCompanyname(vo.getCompanyname());
        company.setCreatetime(new Date());
        company.setDelstatus(0);
        company.setLeader(vo.getUsername());
        company.setPhone(vo.getPhone());
        company.setPrime(vo.getPrime());
        company.setProcince(vo.getProcince());
        company.setQq(vo.getQq());
        company.setSingleBrand(vo.getSingleBrand());
        company.setSingleParts(vo.getSingleParts());
        company.setTel1(vo.getTel1());
        company.setTel2(vo.getTel2());
        company.setZone1(vo.getZone1());
        company.setZone2(vo.getZone2());
        //插入企业信息到企业表
        companyMapper.insertSelective(company);
        //企业表插入成功之后，主键也回填了
        User user = new User();
        user.setCompanyId(company.getId().toString());
        user.setCreatetime(new Date());
        user.setEmail(vo.getEmail());
        user.setLeader(vo.getUsername());
        user.setLoginName(vo.getLoginName());
        //管理员
        user.setManageLevel(1);
        user.setPassword(SHA1Util.encode(vo.getPassword()));
        user.setPhone(vo.getPhone());
        user.setQq(vo.getQq());
        //角色id必须赋值
        user.setRoleId(3);
        user.setUsername(vo.getUsername());
        user.setUserStatus(1);
        //用户表插入成功
        userMapper.insertSelective(user);
    }

    @Override
    public User findUserByUser(String loginName) {
        return userMapper.findUserByUser(loginName);
    }

    @Override
    public User findUserByPhone(String telnum) {
        return userMapper.findUserByPhone(telnum);
    }

    @Override
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    @Override
    public List<Role> loadUserRoles(Integer id) {
        return roleMapper.loadUserRoles(id);
    }

    @Override
    public List<User> findStaff(User user) {
        return userMapper.findStaff(user);
    }


}
