package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.News;

import java.util.List;

public interface NewsMapper extends BaseDao<News> {

    List<News> findNews();
}