package com.yitian.sm.mapper;

import com.yitian.sm.model.Orders;
import com.yitian.sm.model.OrdersAndItems;

import java.util.List;


public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    void insertOrdersAndItems(OrdersAndItems ordersAndItems);
    List<Orders> findOrdersAndItemsById(Integer id);
}