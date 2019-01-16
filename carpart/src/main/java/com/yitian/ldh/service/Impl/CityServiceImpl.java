package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.CityMapper;
import com.yitian.ldh.model.City;
import com.yitian.ldh.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findProvince() {
        return cityMapper.findProvince();
    }

    @Override
    public List<City> findCityByParentId(Integer id) {
        return cityMapper.findCityByParentId(id);
    }
}
