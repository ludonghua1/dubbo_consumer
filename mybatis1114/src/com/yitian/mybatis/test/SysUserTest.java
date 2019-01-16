package com.yitian.mybatis.test;


import com.yitian.mybatis.service.ItemsService;
import com.yitian.mybatis.service.OrdersService;
import com.yitian.mybatis.service.SysUserService;
import com.yitian.mybatis.service.impl.ItemsServiceImpl;
import com.yitian.mybatis.service.impl.OrdersServiceImpl;
import com.yitian.mybatis.service.impl.SysUserServiceImpl;
import org.junit.Test;


public class SysUserTest {
    @Test
    public void test(){
        SysUserService service = new SysUserServiceImpl();
        SysUserService service1 = new SysUserServiceImpl();
        service.findUserById(1);
        service1.findUserById(1);
        //System.out.println(service.findUserById(1));
    }

    @Test
    public void test1(){
        OrdersService os = new OrdersServiceImpl();
        System.out.println(os.selectOrders(1));

    }
    @Test
    public void test2(){
        ItemsService is = new ItemsServiceImpl();
        System.out.println(is.selectById(1));

    }
    @Test
    public void test3(){
        OrdersService service = new OrdersServiceImpl();
        System.out.println(service.findOrdersVo());
    }
    @Test
    public void test4(){
        OrdersService service = new OrdersServiceImpl();
        System.out.println(service.findOrdersUser());
    }
    @Test
    public void test5(){
        OrdersService service = new OrdersServiceImpl();
        System.out.println(service.findOrdersById(1));
    }
    @Test
    public void test6(){
        OrdersService service = new OrdersServiceImpl();
        System.out.println(service.findOrdersByName(1));
    }

    @Test
    public void test7(){
        OrdersService service = new OrdersServiceImpl();
        System.out.println(service.findOrdersAndUser(1));
    }
}
