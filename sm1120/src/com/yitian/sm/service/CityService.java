package com.yitian.sm.service;

import com.yitian.sm.model.City;

import java.util.List;

public interface CityService {
    public List<City> getProvince();

    List<City> getCity(int id);
}
