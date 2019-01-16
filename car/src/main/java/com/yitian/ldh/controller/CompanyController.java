package com.yitian.ldh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("company")
public class CompanyController {
    @RequestMapping("/company.shtml")
    public String company(){
        return "/company/companyManage";
    }
}
