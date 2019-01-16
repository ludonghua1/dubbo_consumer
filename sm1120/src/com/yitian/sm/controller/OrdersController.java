package com.yitian.sm.controller;


import com.yitian.sm.model.Items;
import com.yitian.sm.model.Orders;
import com.yitian.sm.model.OrdersAndItems;
import com.yitian.sm.model.SysUser;
import com.yitian.sm.service.ItemsService;
import com.yitian.sm.service.OrdersService;
import com.yitian.sm.service.impl.ItemsServiceImpl;
import com.yitian.sm.service.impl.OredrsServiceImpl;
import com.yitian.sm.vo.ItemsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class OrdersController {
    ItemsService itemsService = new ItemsServiceImpl();
    OrdersService ordersService = new OredrsServiceImpl();

    @RequestMapping("/makeOrders.action")
    public void makeOrders(String ids, HttpSession session, HttpServletResponse response) throws IOException {
        HashMap map = (HashMap) session.getAttribute("shopping");//取到购物商品的id
        SysUser user = (SysUser) session.getAttribute("user");//取到用户信息  登录时的
        String[] array = ids.split(",");//截成字符串数组
        List<ItemsVo> itemsVoList = new ArrayList<ItemsVo>();
        int ordersMoney=0;
        for(String id:array){
            if(map.containsKey(id)){
                ItemsVo itemsVo = new ItemsVo();
                int shoppingCount = (int) map.remove(id);//获取购买商品的数量    remove的意思是购买后删除   remove(key)返回value值 此处对应的是购买的商品数量
                itemsVo.setShoppingCount(shoppingCount);//给商品数量赋值
                Items items = itemsService.findItemsByIds(Integer.parseInt(id));//传入购买商品的id  在得到该商品的信息  在HashMap当中id是字符串类型的
                itemsVo.setItems(items);//把商品信息储存到itemsVo中
                itemsVoList.add(itemsVo);//添加到集合中
            }
        }
        for(ItemsVo itemsVo:itemsVoList){
            int itemsPrice = Integer.parseInt(itemsVo.getItems().getPrice());//得到商品的价格
            ordersMoney += itemsPrice*itemsVo.getShoppingCount();//对应 商品的数量乘以价格  总价格
        }
        Orders orders = new Orders();
        String money = ordersMoney+"";//转换成字符串  因为数据库类型中是字符串
        orders.setMoney(money);
        Date date = new Date();
        orders.setCreateTime(date);//得到此时的时间  作为当前购买的时间
        orders.setStatus("1");//订单状态
        orders.setUserId(user.getId());//就是登录时用户所对应的id
        ordersService.insertSelective(orders);//增加订单    并根据主键回填 添加上id  因为增加是id是自增的 数据库中会自动生成 但java中没有得到id  （有的数据库自带主键回填）
        for(ItemsVo itemsVo:itemsVoList){//目的给中间表增加信息  for循环是因为  买的商品不止一件
            OrdersAndItems ordersAndItems = new OrdersAndItems();
            ordersAndItems.setItemsId(itemsVo.getItems().getId());
            ordersAndItems.setOrdersId(orders.getId());
            ordersAndItems.setCount(itemsVo.getShoppingCount());
            ordersService.insertOrdersAndItems(ordersAndItems);//增加  中间表
        }//购物车是一对多查询  需要通过中间表进行连接  所以要生成中间表
        session.setAttribute("orders",orders);//存储订单的信息
        response.getWriter().write("success");
    }

    @RequestMapping("/toOrders.action")
    public String toOrders(HttpSession session, HttpServletRequest request){
        Orders orders = (Orders) session.getAttribute("orders");//取到存储的订单信息
        List<Orders> list = ordersService.findOrdersAndItemsById(orders.getId());//通过自增生成的订单id 查订单和商品信息
        request.setAttribute("list",list);//转发  并储存信息
        return "orderList";
    }


}

