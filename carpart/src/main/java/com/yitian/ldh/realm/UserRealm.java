package com.yitian.ldh.realm;

import com.yitian.ldh.model.Menu;
import com.yitian.ldh.model.Role;
import com.yitian.ldh.model.User;
import com.yitian.ldh.service.UserService;
import com.yitian.ldh.token.LoginToken;
import com.yitian.ldh.util.SHA1Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

//    授权方法
//    PrincipalCollection代表所有认证用户的集合
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        User user = (User) collection.getPrimaryPrincipal();
        //根据用户信息查到，用户所有的权限和角色
        List<Role> roleList = userService.loadUserRoles(user.getId());
        List<Menu> menuList = userService.findMenuByUser(user);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> rolesSet = new HashSet<String>();
        Set<String> persSet = new HashSet<String>();
        for(Role role:roleList){
            rolesSet.add(role.getRoleEnglishName());
        }

        for(Menu menu:menuList){
                persSet.add(menu.getUrl());
        }
        info.setRoles(rolesSet);
        info.setStringPermissions(persSet);
        return  info;
    }
//    认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LoginToken loginToken = (LoginToken) token;
        Session session = SecurityUtils.getSubject().getSession();
        String validateCode = (String) session.getAttribute("validate");
        if (loginToken.getValidate()==null||!loginToken.getValidate().toUpperCase().equals(validateCode.toUpperCase())){
            throw  new AccountException("验证码错误！");
        }
        User user = userService.findUserByUser(loginToken.getUsername());
        if (user==null){
            throw  new AccountException("用户名不存在！");
        }else {
            if (!user.getPassword().equals(SHA1Util.encode(new String(loginToken.getPassword())))){
                throw new AccountException("密码错误！");
            }else {
                session.setAttribute("user",user);
            }
        }
        return new SimpleAuthenticationInfo(user,loginToken.getPassword(),getName());
    }
}
