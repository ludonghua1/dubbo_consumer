package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.DymsnMapper;
import com.yitian.ldh.model.Dymsn;
import com.yitian.ldh.service.DymsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DymsnServiceImpl implements DymsnService {
    @Autowired
    private DymsnMapper dymsnMapper;
    @Override
    public List<Dymsn> findDymsn() {
        return dymsnMapper.findDymsn();
    }
}
