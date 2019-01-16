package com.yitian.sm.service;

import com.yitian.sm.model.Orders;
import com.yitian.sm.model.OrdersAndItems;

import java.util.List;


public interface OrdersService {

    int insertSelective(Orders record);

    void insertOrdersAndItems(OrdersAndItems ordersAndItems);

    List<Orders> findOrdersAndItemsById(Integer id);
}
