package com.yitian.spring.service.impl;

import com.yitian.spring.dao.HelloDao;
import com.yitian.spring.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
@Service注解表标示这是业务层，spring会帮你实例化该类型的对象


*/

@Service
public class HelloServiceImpl implements HelloService {
    /*
    * @Autowired注解会去spring的ioc容器当中查找有没有HelloDao类型的对象，
    * */
    @Autowired
    private HelloDao helloDao;
    @Override
    public void sayHello() {
       helloDao.sayHello();
    }
}
