package com.yitian.ssm.service.imp;

import com.yitian.ssm.dao.ItemsMapper;
import com.yitian.ssm.model.Items;
import com.yitian.ssm.service.ItemsService;
import com.yitian.ssm.vo.ItemsVo;
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
    public List<Items> findItemsLike(ItemsVo itemsVo) {
        return itemsMapper.findItemsLike(itemsVo);
    }

    @Override
    public void addItems(Items items) {
        itemsMapper.insertSelective(items);
    }

    @Override
    public List<Items> findItemsShopping(String ids) {
        return itemsMapper.findByIds(ids);
    }

    @Override
    public Items findItemsByIds(int parseInt) {
        return itemsMapper.findItemsById(parseInt);
    }

    @Override
    public List<Items> findByIds(String ids) {
        return  itemsMapper.findByIds(ids);
    }
}
