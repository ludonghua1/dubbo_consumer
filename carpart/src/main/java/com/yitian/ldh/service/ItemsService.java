package com.yitian.ldh.service;

import com.yitian.ldh.model.Items;

import java.util.List;

public interface ItemsService {

    List<Items> findItemsByItems(Items items);
}
