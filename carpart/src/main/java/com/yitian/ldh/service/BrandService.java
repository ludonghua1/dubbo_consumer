package com.yitian.ldh.service;

import com.yitian.ldh.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findBrandAll();

    List<Brand> findBrandList();
}
