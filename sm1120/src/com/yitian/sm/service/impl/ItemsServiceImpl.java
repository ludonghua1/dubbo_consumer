package com.yitian.sm.service.impl;

import com.yitian.sm.mapper.ItemsMapper;
import com.yitian.sm.model.Items;
import com.yitian.sm.model.Orders;
import com.yitian.sm.service.ItemsService;
import com.yitian.sm.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {
    @Override
    public List<Items> findItems() {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper im = session.getMapper(ItemsMapper.class);
        return im.findItems();
    }

    @Override
    public Items findItemsById(Integer id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper im = session.getMapper(ItemsMapper.class);
        return im.findItemsById(id);
    }

    @Override
    public int deleteItems(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper daili = session.getMapper(ItemsMapper.class);
        int ids = daili.deleteItems(id);
        session.commit();
        return ids;
    }

    @Override
    public int updateItems(Items items) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper daili = session.getMapper(ItemsMapper.class);
        int i = daili.updateByPrimaryKeySelective(items);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public List<Items> findItemsLike(Items items) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper daili = session.getMapper(ItemsMapper.class);
        session.close();
        return daili.findItemsLike(items);
    }

    @Override
    public void addItems(Items items) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper im = session.getMapper(ItemsMapper.class);
        im.insertSelective(items);
        session.commit();
        session.close();

    }

    @Override
    public List<Items> findByIds(String ids) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper sm = session.getMapper(ItemsMapper.class);
        return sm.findByIds(ids);
    }

    @Override
    public Items findItemsByIds(Integer parseInt) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper sm = session.getMapper(ItemsMapper.class);
        return sm.selectByPrimaryKey(parseInt);
    }


}
