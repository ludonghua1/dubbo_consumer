package com.yitian.mybatis.service;

import com.yitian.mybatis.model.Orders;
import com.yitian.mybatis.vo.OrdersVo;

import java.util.List;

public interface OrdersService {
    public Orders selectOrders(int id);
    public List<OrdersVo> findOrdersVo();
    public List<Orders> findOrdersUser();
    public Orders findOrdersById(int id);
    public Orders findOrdersByName(int id);
    public Orders findOrdersAndUser(int id);
}
