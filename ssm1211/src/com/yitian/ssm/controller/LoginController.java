package com.yitian.ssm.controller;

import com.yitian.ssm.model.SysUser;
import com.yitian.ssm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/toLogin.")
    public String toLogin(){

        return "login";
    }
    @RequestMapping("/login.")
    public void login(SysUser user,HttpServletResponse response,HttpSession session) throws IOException {
        user = sysUserService.findUser(user);
        if (user!=null) {
            session.setAttribute("user", user);
            response.getWriter().write("1");
        }else {
            response.getWriter().write("0");

        }
    }
    @RequestMapping("/list.")
    public String list(HttpSession session){
        SysUser user = (SysUser) session.getAttribute("user");
        session.setAttribute("user",user);
        return "itemsList";
    }

    @RequestMapping("/toReg.")
    public String toReg(){
        return "reg";
    }

    @RequestMapping("/reg.")
    public String reg(SysUser user,HttpServletResponse response) throws IOException {
         user = sysUserService.findByUser(user.getLoginName());
        if (user!=null){
            //sysUserService.insertUser(user);
            response.getWriter().write("1");
        }else {
            response.getWriter().write("2");
        }
        return "login";
    }
}
