package com.yitian.sm.service.impl;

import com.yitian.sm.mapper.CityMapper;
import com.yitian.sm.model.City;
import com.yitian.sm.service.CityService;
import com.yitian.sm.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CityServiceIpml implements CityService {
    @Override
    public List<City> getProvince() {
        SqlSession session = MybatisUtil.getFactory().openSession();
        CityMapper  cm = session.getMapper(CityMapper.class);
        return cm.getProvince();
    }

    @Override
    public List<City> getCity(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        CityMapper  cm = session.getMapper(CityMapper.class);
        return cm.getCity(id);
    }
}
