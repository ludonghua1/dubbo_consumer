package com.yitian.sm.controller;

import com.yitian.sm.model.Items;
import com.yitian.sm.service.ItemsService;
import com.yitian.sm.service.impl.ItemsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemsController {
    private ItemsService itemsService = new ItemsServiceImpl();
    @RequestMapping("/list.action")
    public String list(HttpServletRequest request){
        List<Items> list = itemsService.findItems();
        request.setAttribute("list",list);
        return "list";
    }

    @RequestMapping("/deleteItems.action")
    public String deleteItems(int id){
        itemsService.deleteItems(id);
        return "redirect:list.action";
    }
    @RequestMapping("/modifyItems.action")
    public String modifyItems(int id,HttpServletRequest request){
        Items list = itemsService.findItemsById(id);
        request.setAttribute("list",list);
        return "update";
    }
    @RequestMapping("/updateItems.action")
    public String updateItems(Items items,HttpServletRequest request){
         itemsService.updateItems(items);
        return "redirect:list.action";
    }
    @RequestMapping("/likeItems.action")
    public String likeItems(HttpServletRequest request, Items items, HttpSession session){
        session.setAttribute("items",items);
        List<Items> list =itemsService.findItemsLike(items);
        request.setAttribute("list",list);
        return "list";
    }
    @RequestMapping("/toAddItems.action")
    public String toAddItems(){
        return "addItems";
    }
    @RequestMapping("/addItems.action")
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
        return "redirect:list.action";
    }

}
