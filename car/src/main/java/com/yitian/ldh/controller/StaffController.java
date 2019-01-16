package com.yitian.ldh.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitian.ldh.model.User;
import com.yitian.ldh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private UserService userService;

    @RequestMapping("/staffList.shtml")
    public String staffList(Integer pageNo, Integer pageSize, String username, HttpSession session, HttpServletRequest request){
        pageNo = pageNo==null?1:pageNo;
        pageSize = pageSize==null?10:pageSize;
        User user = (User) session.getAttribute("user");
        user.setUsername(username);
        PageHelper.startPage(pageNo,pageSize,true);
        List<User> staff = userService.findStaff(user);
        PageInfo<User> page = new PageInfo<User>(staff);
        request.setAttribute("page",page);
        request.setAttribute("username",username);
        return "/staff/staffList";
    }

}
