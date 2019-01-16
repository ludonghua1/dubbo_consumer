package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.PrimeMapper;
import com.yitian.ldh.model.Prime;
import com.yitian.ldh.service.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimeServiceImpl implements PrimeService {
    @Autowired
    private PrimeMapper primeMapper;

    @Override
    public List<Prime> findPrimeList() {
        return primeMapper.findPrimeList();
    }
}
