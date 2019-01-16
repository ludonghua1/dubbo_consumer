package com.yitian.ssm.dao;

import com.yitian.ssm.model.Orders;
import com.yitian.ssm.model.OrdersItemsRelation;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders findOrdersAndItemsById(int parseInt);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}