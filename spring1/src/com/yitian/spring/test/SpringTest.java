package com.yitian.spring.test;

import com.yitian.spring.model.User;
import com.yitian.spring.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {
    /**
     * 注解开发
     * @service 标识该类是一个service的实现类，spring注解扫包器会扫描到该注解，
     * 会进行IOC
     * @repository 标识该类是一个dao的实现类
     * @component  标识该类是一个标准的javabean
     * @autoWired autoWired注解会去spring的ioc容器当中去查找有没有HelloDao类型的对象呢,
     * 找到之后会将该对象注入给被注解标识的这个属性,默认就是通过类型去查找对象的
     *
     * @resource 是jdk提供的,默认是先按照名称查找，如果名称找不到对象，再用类型去查找
     *
     */
    public static void main(String[] args) {
        //1、让spring框架读取核心配置文件，创建ioc容器
        //以相对路径去classPath下面去查找
        //ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        //绝对路径方式去硬盘当中加载：
        FileSystemXmlApplicationContext ioc = new FileSystemXmlApplicationContext("E:\\Project\\spring1\\config\\spring1.xml");
        //2、去容器当中取对象 <1>:通过对象的唯一标示，唯一标示可以是id，也可以是name属性去取对象
        HelloService helloService = (HelloService) ioc.getBean("helloServiceImpl");
        helloService.sayHello();
        //<2>:通过对象的类型去容器当中查对象
        HelloService helloService1=ioc.getBean(HelloService.class);
        helloService1.sayHello();

        User user = (User) ioc.getBean("user");
        System.out.println(user);
    }
}
