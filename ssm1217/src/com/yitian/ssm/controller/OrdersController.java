package com.yitian.ssm.controller;

import com.yitian.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/orders.")
    public String orders(String ids){

        return null;
    }

}
