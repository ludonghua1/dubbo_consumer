package com.yitian.ldh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitian.ldh.model.Brand;
import com.yitian.ldh.model.Items;
import com.yitian.ldh.model.Parts;
import com.yitian.ldh.service.BrandService;
import com.yitian.ldh.service.ItemsService;
import com.yitian.ldh.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private PartsService partsService;
    @RequestMapping("/publicList.shtml")
    public String publicList(Integer pageNo, Integer pageSize, Items items, HttpServletRequest request){
        //初始化分页
        pageNo = pageNo==null?1:pageNo;
        pageSize = pageSize==null?8:pageSize;
        //开始分页
        PageHelper.startPage(pageNo,pageSize);
        List<Items> list = itemsService.findItemsByItems(items);
        PageInfo<Items> page = new PageInfo<Items>(list);
        List<Brand> brandList = brandService.findBrandAll();
        request.setAttribute("brandList",brandList);
        List<Parts> partsList = partsService.findPartsAll();
        request.setAttribute("partsList",partsList);
        request.setAttribute("items",items);
        request.setAttribute("page",page);
        return "/items/publicList";
    }
}
