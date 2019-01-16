package com.yitian.sm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yitian.sm.model.Items;
import com.yitian.sm.model.SysUser;
import com.yitian.sm.service.ItemsService;
import com.yitian.sm.service.impl.ItemsServiceImpl;
import com.yitian.sm.vo.ItemsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.*;


@Controller
public class ShoppingController {
    private ItemsService itemsService = new ItemsServiceImpl();
    @RequestMapping("/shopping.action")
    public void shoping(String ids, HttpSession session, HttpServletResponse response,HttpServletRequest request) throws Exception {
       SysUser user= (SysUser) session.getAttribute("user");
        if (user!=null) {
            if (session.getAttribute("shopping") == null) {
                //用hashmap来代替字符串存id这种形式
                String[] array = ids.split(",");
                //将字符串
                HashMap<String, Integer> map = new HashMap();
                for (String id : array) {
                    map.put(id, 1);
                }
                session.setAttribute("shopping", map);
            } else {
                HashMap map = (HashMap) session.getAttribute("shopping");
                String[] array = ids.split(",");
                for (String id : array) {
                    if (map.containsKey(id)) {
                        int conut = (int) map.get(id);
                        conut++;
                        map.put(id, conut);
                    } else {
                        map.put(id, 1);
                    }
                }
            }
            response.getWriter().write("success");
        }else {
            response.getWriter().write("1");
        }
    }

    @RequestMapping("/shoppingCart.action")
    public String shoppinglist(HttpSession session, HttpServletRequest request){
        if (session.getAttribute("shopping")!=null){
            HashMap map = (HashMap) session.getAttribute("shopping");
            //map key是商品的id value是商品的购物车添加次数
            Set set = map.keySet();
            Iterator it = set.iterator();
            List<ItemsVo> list = new ArrayList<ItemsVo>();
            while (it.hasNext()){
                //取到map的key
                String id = (String) it.next();
                //通过id把商品详情查出来
                Items items = itemsService.findItemsByIds(Integer.parseInt(id));
                ItemsVo itemsVo = new ItemsVo();
                itemsVo.setItems(items);
                int value = (int) map.get(id);
                itemsVo.setShoppingCount(value);
                list.add(itemsVo);
            }
            request.setAttribute("list",list);
        }
        return "shopcat";
    }
    //删除购物车中选中的商品
    @RequestMapping("/delshopping.action")
    public void delshopping(String ids,HttpSession session,HttpServletResponse response) throws Exception {
        SysUser user= (SysUser) session.getAttribute("user");
        if (user!=null) {
            HashMap map = (HashMap) session.getAttribute("shopping");
            String[] array = ids.split(",");
            for (String id : array) {
                if (map.containsKey(id)) {
                    map.remove(id);
                }
            }
            response.getWriter().write("success");
        }else {
            response.getWriter().write("1");
        }
    }


}
