package com.yitian.sm.controller;

import com.yitian.sm.model.City;
import com.yitian.sm.service.CityService;
import com.yitian.sm.service.impl.CityServiceIpml;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegController {
    private CityService cityService = new CityServiceIpml();
    @RequestMapping("/toReg.action")
    public String toReg(){
        return "reg";
    }
    @RequestMapping("/getProvince.action")
    public @ResponseBody List<City> getProvince(){
        //查询所有的省出来，然后转成json字符串，然后再响应给客户端ajax回调函数
        List<City> list = cityService.getProvince();
        //将list转成json
        return list;
    }
    @RequestMapping("/getCity.action")
    public @ResponseBody List<City> getCity(int id){
        //查询所有的省出来，然后转成json字符串，然后再响应给客户端ajax回调函数
        List<City> list = cityService.getCity(id);
        //将list转成json
        return list;
    }
}
