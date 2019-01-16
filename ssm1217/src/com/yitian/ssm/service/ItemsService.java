package com.yitian.ssm.service;

import com.yitian.ssm.model.Items;
import com.yitian.ssm.vo.ItemsVo;

import java.util.List;

public interface ItemsService {
    List<Items> findItems();

    void deleteItems(int id);

    Items findItemsById(int id);

    void updateItems(Items items);

    List<Items> findItemsLike(ItemsVo itemsVo);

    void addItems(Items items);

    List<Items> findItemsShopping(String ids);

    Items findItemsByIds(int parseInt);

    List<Items> findByIds(String ids);
}
