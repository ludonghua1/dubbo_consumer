package com.yitian.ldh.webservice.rest;

import com.yitian.ldh.model.User;
import com.yitian.ldh.service.UserService;
import com.yitian.ldh.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findUserByUsername.shtml")
    public @ResponseBody User findUserByUsername(LoginVo vo){
        User user = userService.findUserByLoginNameAndEmail(vo);
        return user;
    }
}
