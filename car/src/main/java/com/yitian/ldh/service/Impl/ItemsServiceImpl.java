package com.yitian.ldh.service.Impl;


import com.yitian.ldh.dao.ItemsMapper;
import com.yitian.ldh.model.Items;
import com.yitian.ldh.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> findItemsByItems(Items items) {
        return itemsMapper.findItemsByItems(items);
    }
}
