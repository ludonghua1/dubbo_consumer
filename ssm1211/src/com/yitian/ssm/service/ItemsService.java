package com.yitian.ssm.service;

import com.yitian.ssm.model.Items;
import com.yitian.ssm.vo.ItemsVo;

import java.util.List;

public interface ItemsService {
    List<Items> findItems();

    void deleteItems(int id);

    Items findItemsById(int id);

    void updateItems(Items items);

    List<Items> findItemsLike(Items items);

    void addItems(Items items);
}
