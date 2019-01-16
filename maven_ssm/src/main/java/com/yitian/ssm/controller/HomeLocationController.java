package com.yitian.ssm.controller;


import com.yitian.ssm.util.IpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeLocationController {
    @RequestMapping("/homeLocation.shtml")
    public void homeLocation(String ip, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String ips = IpUtils.getProvince(ip);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(ips);


    }


}
