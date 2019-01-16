package com.yitian.mybatis.mapper;

import com.yitian.mybatis.model.Orders;
import com.yitian.mybatis.vo.OrdersVo;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    public List<OrdersVo> findOrdersVo();

    public List<Orders> findOrdersUser();

    public Orders findOrdersById(int id);

    public Orders findOrdersByName(int id);

    public Orders findOrdersAndUser(int id);

}