package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.MenuMapper;
import com.yitian.ldh.model.Menu;
import com.yitian.ldh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }
}
