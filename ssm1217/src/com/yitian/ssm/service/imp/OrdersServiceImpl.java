package com.yitian.ssm.service.imp;

import com.yitian.ssm.dao.OrdersMapper;
import com.yitian.ssm.model.Orders;
import com.yitian.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public int insert(Orders orders) {
        return ordersMapper.insert(orders);
    }
}
