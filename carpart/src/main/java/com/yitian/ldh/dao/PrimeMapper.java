package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Prime;

import java.util.List;

public interface PrimeMapper extends BaseDao<Prime> {

    List<Prime> findPrimeList();
}