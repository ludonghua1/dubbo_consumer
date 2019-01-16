package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.PartsMapper;
import com.yitian.ldh.model.Parts;
import com.yitian.ldh.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {
    @Autowired
    private PartsMapper partsMapper;

    @Override
    public List<Parts> findPartsAll() {
        return partsMapper.findPartsAll();
    }

    @Override
    public List<Parts> findPartsList() {
        return partsMapper.findPartsAll();
    }
}
