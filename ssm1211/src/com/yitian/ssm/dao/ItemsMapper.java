package com.yitian.ssm.dao;

import com.yitian.ssm.model.Items;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);

    List<Items> findItems();

    List<Items> findItemsLike(Items items);
}