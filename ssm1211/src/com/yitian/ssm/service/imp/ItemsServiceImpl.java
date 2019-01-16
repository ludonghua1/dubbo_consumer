package com.yitian.ssm.service.imp;

import com.yitian.ssm.dao.ItemsMapper;
import com.yitian.ssm.model.Items;
import com.yitian.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> findItems() {

        return itemsMapper.findItems();
    }

    @Override
    public void deleteItems(int id) {
        itemsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Items findItemsById(int id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItems(Items items) {
        itemsMapper.updateByPrimaryKeySelective(items);
    }

    @Override
    public List<Items> findItemsLike(Items items) {
        return itemsMapper.findItemsLike(items);
    }

    @Override
    public void addItems(Items items) {
        itemsMapper.insertSelective(items);
    }
}
