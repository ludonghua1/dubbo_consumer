package com.yitian.ldh.service;

import com.yitian.ldh.model.Parts;

import java.util.List;

public interface PartsService {
    List<Parts> findPartsAll();

    List<Parts> findPartsList();
}
