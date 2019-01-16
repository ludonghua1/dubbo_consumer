package com.yitian.ssm.service.imp;

import com.yitian.ssm.dao.OrdersItemsRelationMapper;
import com.yitian.ssm.dao.OrdersMapper;
import com.yitian.ssm.model.Orders;
import com.yitian.ssm.model.OrdersItemsRelation;
import com.yitian.ssm.service.OrdersItemsRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersItemsRelationServiceImpl implements OrdersItemsRelationService {
    @Autowired
    private OrdersItemsRelationMapper ordersItemsRelationMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public void addRelation(Orders record,OrdersItemsRelation ordersItemsRelation) {
        ordersMapper.insertSelective(record);
        ordersItemsRelation.setOrdersId(record.getId());
        ordersItemsRelationMapper.insertSelective(ordersItemsRelation);

    }
}
