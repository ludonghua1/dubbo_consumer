package com.yitian.service.Impl;

import com.yitian.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void say(String name) {
        System.out.println("hello   "+name);
    }
}
