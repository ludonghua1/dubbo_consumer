package com.yitian.sm.service;

import com.yitian.sm.model.Items;

import java.util.List;

public interface ItemsService {
    public List<Items> findItems();
    public Items findItemsById(Integer id);
    public int deleteItems(int id);
    public int updateItems(Items items);
    public List<Items> findItemsLike(Items items);
    public void addItems(Items items);
    public List<Items> findByIds(String ids);
    public Items findItemsByIds(Integer parseInt);


}

