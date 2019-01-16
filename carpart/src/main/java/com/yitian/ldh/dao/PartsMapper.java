package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Parts;

import java.util.List;

public interface PartsMapper extends BaseDao<Parts> {

    List<Parts> findPartsAll();

}