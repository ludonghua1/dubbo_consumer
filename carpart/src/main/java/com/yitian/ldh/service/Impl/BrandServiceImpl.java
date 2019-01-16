package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.BrandMapper;
import com.yitian.ldh.model.Brand;
import com.yitian.ldh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findBrandAll() {
        return brandMapper.findBrandAll();
    }

    @Override
    public List<Brand> findBrandList() {
        return brandMapper.findBrandAll();
    }
}
