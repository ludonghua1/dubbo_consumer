package com.yitian.ssm.service;

import com.yitian.ssm.model.Orders;


public interface OrdersService {
    void addOrders(Orders orders);

    Orders findOrdersAndItemsById(int id);
}
