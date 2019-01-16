package com.yitian.ssm.controller;

import com.yitian.ssm.model.SysUser;
import com.yitian.ssm.service.SysUserService;
import com.yitian.ssm.util.AHA1Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.JedisCluster;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;


@Controller
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JedisCluster jedisCluster;
    @RequestMapping("/toLogin.shtml")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login.shtml")
    public void login(boolean rem, SysUser user, HttpServletResponse response, HttpSession session, HttpServletRequest request) throws IOException {
        user = sysUserService.findUser(user);
        if (user!=null){
            //生成token令牌
            String token = "login:"+AHA1Util.encode(user.getLoginName());
            HashMap<String,String> map =new HashMap<String, String>();
            map.put("id",user.getId()+"");
            map.put("loginName",user.getLoginName());
            map.put("password",user.getPassword());
            //将token存入到jedisCluster中
            jedisCluster.hmset(token,map);
            //设置token时效
            jedisCluster.expire(token,2592000);
            //将token存到cookie中
            Cookie cookie = new Cookie("login",token);
            //将cookie发送到客户端
            response.addCookie(cookie);
            response.getWriter().write("1");
        }else {
            response.getWriter().write("0");
        }
    }
    @RequestMapping("/index.shtml")
    public String index(HttpSession session){

        return "index";
    }

    @RequestMapping("/toReg.shtml")
    public String toReg(){
        return "reg";
    }

    @RequestMapping("/reg.shtml")
    public String reg(SysUser user,HttpServletResponse response) throws IOException {
         user = sysUserService.findByUser(user.getLoginName());
        if (user!=null){
            response.getWriter().write("1");
        }else {
            response.getWriter().write("2");
        }
        return "login";
    }
}
