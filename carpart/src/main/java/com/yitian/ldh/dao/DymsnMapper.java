package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Dymsn;

import java.util.List;

public interface DymsnMapper extends BaseDao<Dymsn> {

    List<Dymsn> findDymsn();
}