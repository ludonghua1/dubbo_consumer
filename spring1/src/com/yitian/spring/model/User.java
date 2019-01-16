package com.yitian.spring.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String username="张三";
    private String password="123";
    private Integer age=23;


    @Override
    public String toString() {
        return "User[" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ']';
    }
}
