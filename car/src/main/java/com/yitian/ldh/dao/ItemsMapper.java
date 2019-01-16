package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Items;

import java.util.List;

public interface ItemsMapper extends BaseDao<Items> {

    List<Items> findItemsByItems(Items items);
}