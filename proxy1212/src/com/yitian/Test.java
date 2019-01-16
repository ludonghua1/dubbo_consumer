package com.yitian;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/*
* 动态代理：某些场景下，原业务类的功能满足不了需求时，而且我又不想改变源代码，
* 这个时候就可以使用代理机制，对原业务类进行功能的扩充增强，前置增强、后置增强
* 等。
* JDK提供的动态代理机制，它要求原业务类必须实现接口，除了JDK之外，第三方
* 的CGLIB也可以实现动态代理，它不要实现接口，他的实现是通过创建原业务类的
* 子类对象，进行功能扩充的。
* */
public class Test {
    public static void main(String[] args) {
        //通常情况下
//        Dell dell = new Dell();
//        dell.start();
        //动态代理的使用场景，不改变原有业务类，也不新增业务类。
        //使用JDK的proxy对象，去创建一个动态代理的实例                     类加载器（加载原业务类）        原业务类实现的接口            反射执行器
        Computer daili = (Computer) Proxy.newProxyInstance(Dell.class.getClassLoader(), Dell.class.getInterfaces(), new InvocationHandler() {
            //invoke方法是代理对象在运行方法时，真正运行的逻辑
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //前置增强
                if (method.getName().contains("start")){
                    System.out.println("插上电源");
                }
                //创建原业务类对象
                Dell dell = new Dell();
                //传进来的是什么方法，就执行原业务类的方法
                Object result = method.invoke(dell, args);
                //result是原业务类的运行结果
                //后置增强
                if (method.getName().contains("close")){
                    System.out.println("拔出电源");
                }
                return result;
            }
        });
        daili.start();
    }
}
