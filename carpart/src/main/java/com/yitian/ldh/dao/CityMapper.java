package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.City;

import java.util.List;

public interface CityMapper extends BaseDao<City> {

    List<City> findProvince();

    List<City> findCityByParentId(Integer id);
}