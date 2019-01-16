package com.yitian.sm.service.impl;

import com.yitian.sm.mapper.OrdersMapper;

import com.yitian.sm.model.Orders;
import com.yitian.sm.model.OrdersAndItems;
import com.yitian.sm.service.OrdersService;
import com.yitian.sm.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class OredrsServiceImpl implements OrdersService {
    @Override
    public int insertSelective(Orders record) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        int i = om.insert(record);
        session.commit();
        return i;

    }

    @Override
    public void insertOrdersAndItems(OrdersAndItems ordersAndItems) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        om.insertOrdersAndItems(ordersAndItems);
        session.commit();
    }

    @Override
    public List<Orders> findOrdersAndItemsById(Integer id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        return om.findOrdersAndItemsById(id);
    }

}
