package com.yitian.ldh.service;

import com.yitian.ldh.model.City;

import java.util.List;

public interface CityService {

    List<City> findProvince();

    List<City> findCityByParentId(Integer id);
}
