package com.yitian.mybatis.service.impl;

import com.yitian.mybatis.mapper.ItemsMapper;
import com.yitian.mybatis.model.Items;
import com.yitian.mybatis.service.ItemsService;
import com.yitian.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class ItemsServiceImpl implements ItemsService {
    @Override
    public Items selectById(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ItemsMapper im = session.getMapper(ItemsMapper.class);
        return im.selectByPrimaryKey(id);
    }
}
