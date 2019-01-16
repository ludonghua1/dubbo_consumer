package com.yitian.advice;

public class MyAdvice {
    public void before(){
        System.out.println("开启事务");
    }
    public void after(){
        System.out.println("提交事务");
    }
}
