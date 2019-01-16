package com.yitian.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitian.ssm.model.Items;
import com.yitian.ssm.service.ItemsService;
import com.yitian.ssm.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/itemsList.")
    public String items(Integer pageNo,Integer pageSize,HttpServletRequest request){
        int flag = 0;
        //
        pageNo = pageNo==null?1:pageNo;
        pageSize = pageSize==null?10:pageSize;
        //开启分页拦截
        PageHelper.startPage(pageNo,pageSize);
        //查询出满足条件的所有数据
        List<Items> itemsList = itemsService.findItems();
        //使用封装类，对查询结果进行分页处理
        PageInfo<Items> page = new PageInfo<Items>(itemsList);
        //将分页对象page存入request域返回给jsp页面
        request.setAttribute("page",page);
        request.setAttribute("flag",flag);
        return "itemsList";
    }
    @RequestMapping("/deleteItems.")
    public String deleteItems(int id){
        itemsService.deleteItems(id);
        return "redirect:itemsList.";
    }
    @RequestMapping("/modifyItems.")
    public String modifyItems(int id,HttpServletRequest request){
        Items list = itemsService.findItemsById(id);
        request.setAttribute("list",list);
        return "update";
    }
    @RequestMapping("/updateItems.")
    public String updateItems(Items items){

        itemsService.updateItems(items);
        return "redirect:itemsList.";
    }
    @RequestMapping("/likeItems.")
    public String likeItems(HttpServletRequest request, ItemsVo itemsVo, Integer pageNo, Integer pageSize){
        int flag = 1;
        pageNo = pageNo==null?1:pageNo;
        pageSize = pageSize==null?10:pageSize;
        //开启分页拦截
        PageHelper.startPage(pageNo,pageSize);
        List<Items> itemsList =itemsService.findItemsLike(itemsVo);
        //使用封装类，对查询结果进行分页处理
        PageInfo<Items> page = new PageInfo<Items>(itemsList);
        //将分页对象page存入request域返回给jsp页面
        request.setAttribute("page",page);
        request.setAttribute("itemsVo",itemsVo);
        request.setAttribute("flag",flag);
        return "itemsList";
    }
    @RequestMapping("/toAddItems.")
    public String toAddItems(){
        return "addItems";
    }
    @RequestMapping("/addItems.")
    public String addItems(Items items, MultipartFile file) throws IOException {
        //表单当中包含了字符串参数以及文件
        //1、将文件存储到硬盘真实的物理位置 d:\\pic\+文件名
        String oldName = file.getOriginalFilename();
        //取到原始的文件名
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //取到文件名的后缀 .jpg
        String newName = UUID.randomUUID().toString()+suffix;
        //将内存中的文件对象存储到指定的位置
        String realPath = "d:\\pic\\"+newName;
        file.transferTo(new File(realPath));
        String path = "/pic/"+newName;
        items.setImgUrl(path);
        //插入商品到数据库
        itemsService.addItems(items);
        return "redirect:itemsList.";
    }
}
