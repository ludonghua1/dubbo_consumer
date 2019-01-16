package com.yitian.test;

import com.yitian.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
* aop的实现原理：
* 首先通过aop配置切面以及切面的增强逻辑，当spring容器中的目标类对象
* 的方法被调用时，aop框架就会被拦截此次调用，aop框架会帮你生成一个
* 动态代理对象，先运行增强类的前置增强方法，在运行原业务类的业务方法，
* 最后运行增强类的后置增强方法
*/
public class AopTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        //取目标对象
        UserService userService = (UserService) ioc.getBean("userService");
        //调用目标对象的方法（目标对象满足aop的切面配置，会被aop拦截）
        userService.updateUser();

    }
}
