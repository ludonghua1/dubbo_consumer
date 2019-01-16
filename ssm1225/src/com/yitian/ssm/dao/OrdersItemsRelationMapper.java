package com.yitian.ssm.dao;

import com.yitian.ssm.model.OrdersItemsRelation;

public interface OrdersItemsRelationMapper {
    int insert(OrdersItemsRelation record);

    int insertSelective(OrdersItemsRelation record);
}