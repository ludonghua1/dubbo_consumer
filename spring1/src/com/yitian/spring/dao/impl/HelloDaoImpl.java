package com.yitian.spring.dao.impl;

import com.yitian.spring.dao.HelloDao;
import org.springframework.stereotype.Repository;
/*
* @Repository标示这是一个dao的实现类
* */

@Repository
public class HelloDaoImpl implements HelloDao {
    @Override
    public void sayHello() {
        System.out.println("hello word!");
    }
}
