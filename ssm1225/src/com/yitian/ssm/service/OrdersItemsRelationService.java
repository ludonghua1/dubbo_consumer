package com.yitian.ssm.service;

import com.yitian.ssm.model.Orders;
import com.yitian.ssm.model.OrdersItemsRelation;

public interface OrdersItemsRelationService {
    void addRelation(Orders orders,OrdersItemsRelation ordersItemsRelation);
}
