package com.yitian.ssm.service.imp;

import com.yitian.ssm.dao.OrdersMapper;
import com.yitian.ssm.model.Orders;
import com.yitian.ssm.model.OrdersItemsRelation;
import com.yitian.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;


    @Override
    public void addOrders(Orders orders) {
        ordersMapper.insertSelective(orders);


    }

    @Override
    public Orders findOrdersAndItemsById(int id) {
        return ordersMapper.findOrdersAndItemsById(id);
    }


}
