package com.yitian.spring.test;

import com.yitian.spring.service.impl.HelloServiceImpl;
import com.yitian.spring.service.HelloService;

public class MainTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHello();
    }
}
