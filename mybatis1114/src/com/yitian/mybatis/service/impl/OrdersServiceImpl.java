package com.yitian.mybatis.service.impl;


import com.yitian.mybatis.mapper.OrdersMapper;
import com.yitian.mybatis.model.Orders;
import com.yitian.mybatis.model.SysUser;
import com.yitian.mybatis.service.OrdersService;
import com.yitian.mybatis.util.MybatisUtil;
import com.yitian.mybatis.vo.OrdersVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class OrdersServiceImpl implements OrdersService {

    @Override
    public Orders selectOrders(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        return om.selectByPrimaryKey(id);
    }

    @Override
    public List<OrdersVo> findOrdersVo() {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        return om.findOrdersVo();
    }

    @Override
    public List<Orders> findOrdersUser() {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        return om.findOrdersUser();
    }

    @Override
    public Orders findOrdersById(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        return om.findOrdersById(id);
    }

    @Override
    public Orders findOrdersByName(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        return om.findOrdersByName(id);
    }

    @Override
    public Orders findOrdersAndUser(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        return om.findOrdersAndUser(id);
    }
}
