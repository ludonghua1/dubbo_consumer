package com.yitian.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class TestController {
    @RequestMapping("/test.action")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        response.getWriter().write("welcome "+username+" to your first springmvc project");
    }

}
