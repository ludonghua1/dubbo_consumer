package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Brand;

import java.util.List;


public interface BrandMapper extends BaseDao<Brand> {

    List<Brand> findBrandAll();

}