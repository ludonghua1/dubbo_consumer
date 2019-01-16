package com.yitian.ldh.controller;


import com.yitian.ldh.model.*;
import com.yitian.ldh.service.*;
import com.yitian.ldh.token.LoginToken;
import com.yitian.ldh.util.SHA1Util;
import com.yitian.ldh.vo.LoginVo;
import com.yitian.ldh.vo.RegisterVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private UserService userService;
    @Autowired
    private PartsService partsService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private PrimeService primeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CityService cityService;
    @RequestMapping("/toLogin.shtml")
    public String toLogin(){
        return "/login/login";
    }
//    登录
    @RequestMapping("/login.shtml")
    public void  login(LoginVo vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //创建token令牌
        LoginToken token = new LoginToken(vo.getLoginName(),vo.getPassword(),true,vo.getValidate());
        //当前用户登录完成之后进入realm进行身份认证以及授权的工作
        String result = "success";
        try{
        subject.login(token);
        }catch (Exception e){
        result = e.getMessage();
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(result);
    }
//    public void login(LoginVo vo, HttpSession session, HttpServletResponse response) throws IOException {
//        String code = (String) session.getAttribute("validate");
//        if (vo.getValidate().toUpperCase().equals(code.toUpperCase())){
//            //将密码加密后存入
//            vo.setPassword(SHA1Util.encode(vo.getPassword()));
//            User user = userService.findUserByUsernameAndPassword(vo);
//            if (user==null){
//                response.getWriter().write("2");
//            }else {
//                session.setAttribute("user",user);
//                response.getWriter().write("3");
//            }
//        }else {
//            response.getWriter().write("1");
//        }
//    }
//    退出登录
//    @RequestMapping("/logout.shtml")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "redirect:toLogin.shtml";
//    }
//
    @RequestMapping("/forgetPassword.shtml")
    public String forgetPassword(){
        return "/login/forgetPassword";
    }

    @RequestMapping("/getPassword.shtml")
    public void getPassword(LoginVo vo, HttpServletResponse response) throws Exception{
        //验证用户名和邮箱是否存在
        User user=userService.findUserByLoginNameAndEmail(vo);
        if(user==null){
            //用户不存在
            response.getWriter().write("0");
        }else{
            Random random = new Random();
            String password = "";
            for (int i=0;i<6;i++){
                password+=random.nextInt(10);
            }
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("欢迎使用密码找回");
            message.setText("您的新密码是"+password);
            message.setFrom("15801159100ms@sina.com");
            message.setTo(user.getEmail());
            //让线程池去捞取线程发送邮件
            Runnable task = new EmailThread(message);
            threadPoolTaskExecutor.execute(task);
            //更改密码
            user.setPassword(SHA1Util.encode(password));
            userService.updateUser(user);
            response.getWriter().write("1");
        }
    }
    //    非法访问
    @RequestMapping("/un.shtml")
    public String un(){
        return "/commons/un";
    }
    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/toRegister.shtml")
    public String toRegister(HttpServletRequest request){
        //查询品牌、配件种类、精品信息，用于页面展示
        List<Brand> brandList=brandService.findBrandList();
        List<Parts> partsList=partsService.findPartsList();
        List<Prime> primeList=primeService.findPrimeList();
        request.setAttribute("brandList",brandList);
        request.setAttribute("partsList",partsList);
        request.setAttribute("primeList",primeList);
        return "/login/register";
    }
    //登录名验证
    @RequestMapping("/checkLoginName.shtml")
    public void checkLoginName(String loginName,HttpServletResponse response) throws IOException {
        User user = userService.findUserByUser(loginName);
        if (user==null){
            response.getWriter().write("1");
        }else {
            response.getWriter().write("2");
        }
    }
    //获取省
    @RequestMapping("/getProvince.shtml")
    public @ResponseBody List<City> getProvince(){
            List<City> city = cityService.findProvince();
        return city;
    }
    //获取市或县
    @RequestMapping("/getCity.shtml")
    public @ResponseBody List<City> getCity(Integer id){
        List<City> city = cityService.findCityByParentId(id);
        return city;
    }
    //校验手机号
    @RequestMapping("/checkPhone.shtml")
    public void checkPhone(String telnum,HttpServletResponse response) throws IOException {
        User user = userService.findUserByPhone(telnum);
        if (user==null){
            response.getWriter().write("1");
        }else {
            response.getWriter().write("2");
        }
    }
    //校验邮箱
    @RequestMapping("/checkEmail.shtml")
    public void checkEmail(String email,HttpServletResponse response) throws IOException {
        User user = userService.findUserByEmail(email);
        if (user==null){
            response.getWriter().write("1");
        }else {
            response.getWriter().write("2");
        }
    }
    //校验企业名
    @RequestMapping("/checkCompanyname.shtml")
    public void checkCompanyname(String companyname,HttpServletResponse response) throws IOException {
        User user = companyService.findCompanyname(companyname);
        if (user==null){
            response.getWriter().write("1");
        }else {
            response.getWriter().write("2");
        }
    }
    //注册完成，去登录
    @RequestMapping("/register.shtml")
    public String register(RegisterVo vo){
        userService.addRegister(vo);
        return "redirect:toLogin.shtml";
    }

}
