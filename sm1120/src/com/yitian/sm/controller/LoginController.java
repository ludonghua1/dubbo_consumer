package com.yitian.sm.controller;

import com.yitian.sm.model.SysUser;
import com.yitian.sm.service.SysUserService;
import com.yitian.sm.service.impl.SysUserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController{
    private SysUserService sysUserService = new SysUserServiceImpl();
    @RequestMapping("/toLogin.action")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login.action")
    public void  login(boolean rem, SysUser user, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        user = sysUserService.findSysUserAndPassword(user);
        if (user!=null){
        session.setAttribute("user",user);
        boolean check = false;
            if (rem){
                Cookie[] array = request.getCookies();
                for (Cookie c:array){
                    if (c.getName().equals("loginName")){
                        check=true;
                        break;
                    }
                }
                if (!check){
                //创建cookie
                Cookie cookie = new Cookie("loginName",user.getLoginName());
                //设置cookie的有效期限
                cookie.setMaxAge(2592000);
                //发送cookie
                Cookie cookie1 = new Cookie("password",user.getPassword());
                cookie1.setMaxAge(2592000);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                }
            }else{
                Cookie [] array = request.getCookies();
                for (Cookie c:array){
                    if (c.getName().equals("loginName")||c.getName().equals("password")){
                        c.setMaxAge(2592000);
                        response.addCookie(c);
                    }
                }
            }
        response.getWriter().write("1");
        }else {
        response.getWriter().write("0");
        }

    }
    @RequestMapping("/index.action")
    public String index(HttpSession session){
        SysUser user = (SysUser) session.getAttribute("user");
        session.setAttribute("user",user);
        return "index";
    }
}
