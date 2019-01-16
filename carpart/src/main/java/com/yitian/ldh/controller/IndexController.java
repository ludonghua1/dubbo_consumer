package com.yitian.ldh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitian.ldh.model.*;
import com.yitian.ldh.service.DymsnService;
import com.yitian.ldh.service.NewsService;
import com.yitian.ldh.service.NoticeService;
import com.yitian.ldh.service.UserService;
import com.yitian.ldh.util.SHA1Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private DymsnService dymsnService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private NewsService newsService;
//    跳转到首页
    @RequestMapping("/index.shtml")
    public String index(){
        return "/index/index";
    }
//    首页头部
    @RequestMapping("/top.shtml")
    public String top(HttpServletRequest request){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        request.setAttribute("now",now);
        return "/commons/top";
    }
//    首页导航
    @RequestMapping("/navigation.shtml")
    public String navigation(HttpSession session,HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        List<Menu> menuList = userService.findMenuByUser(user);
        request.setAttribute("menuList",menuList);
        return "/commons/navigation";
    }
//    动态消息
    @RequestMapping("/dymsn.shtml")
    public String dymsn(HttpServletRequest request){
        List<Dymsn> List =  dymsnService.findDymsn();
        request.setAttribute("list",List);
        return "index/dymsn";
    }
//    公告分页查询
    @RequestMapping("/notice.shtml")
    public String notice(Integer pageNo,Integer pageSize,HttpServletRequest request){
        // 初始化分页参数
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        // 利用pageHelper开始进行分页 第三个参数代表是否查询总条数
        // pageHelper使用的是拦截器的原理,
        PageHelper.startPage(pageNo, pageSize, true);
        // 注意:开始进行查询 noticeList是动态代理对象
        List<Notice> noticeList = noticeService.findNotice();
        // 创建一个pageInfo的对象
        PageInfo<Notice> page = new PageInfo<Notice>(noticeList);
        // 将分页信息及数据存request,传递给jsp
        request.setAttribute("page", page);
        return "/index/notice";
    }
//    新闻

    @RequestMapping("/news.shtml")
    public String news(Integer pageNo,Integer pageSize,HttpServletRequest request){
        // 初始化分页参数
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        // 利用pageHelper开始进行分页 第三个参数代表是否查询总条数
        // pageHelper使用的是拦截器的原理,
        PageHelper.startPage(pageNo, pageSize, true);
        List<News> news = newsService.findNews();
        // 创建一个pageInfo的对象
        PageInfo<News> page = new PageInfo<News>(news);
        // 将分页信息及数据存request,传递给jsp
        request.setAttribute("page", page);
        return "/index/news";
    }
//    修改密码
    @RequestMapping("/toChangePassword.shtml")
    public String toChangePassword(){
        return "/index/changePassword";
    }

    @RequestMapping("/changePassword.shtml")
    public void changePassword(String oldPwd, String newPwd, HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("user");
        if (user.getPassword().equals(SHA1Util.encode(oldPwd))){
            user.setPassword(SHA1Util.encode(newPwd));
            userService.updateUserByPassword(user);
            response.getWriter().write("1");
        }else {
            response.getWriter().write("2");
        }
    }

}
