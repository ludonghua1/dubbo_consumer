package com.yitian.ssm.dao;

import com.yitian.ssm.model.Items;
import com.yitian.ssm.vo.ItemsVo;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);

    List<Items> findItems();

    List<Items> findItemsLike(ItemsVo itemsVo);

    List<Items> findByIds(String ids);

    Items findItemsById(int parseInt);
}