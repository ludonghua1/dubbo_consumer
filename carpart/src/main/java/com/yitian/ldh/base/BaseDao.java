package com.yitian.ldh.base;

import com.yitian.ldh.model.Brand;

public interface BaseDao<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    Brand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
