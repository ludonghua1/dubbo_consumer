package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.NewsMapper;
import com.yitian.ldh.model.News;
import com.yitian.ldh.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> findNews() {
        return newsMapper.findNews();
    }
}
