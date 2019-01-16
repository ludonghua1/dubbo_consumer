package com.yitian.sm.mapper;

import com.yitian.sm.model.Items;
import com.yitian.sm.model.Orders;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);

    List<Items> findItems();

    public Items findItemsById(Integer id);
    public int deleteItems(int id);
    public int updateItems(Items items);
    public List<Items> findItemsLike(Items items);
    public List<Items> findByIds(String ids);
}