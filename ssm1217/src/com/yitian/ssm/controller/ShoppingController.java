package com.yitian.ssm.controller;

import com.yitian.ssm.model.Items;
import com.yitian.ssm.model.SysUser;
import com.yitian.ssm.model.Vo;
import com.yitian.ssm.service.ItemsService;
import com.yitian.ssm.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ShoppingController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/shopping.shtml")
    public void shopping(String ids, HttpSession session, HttpServletResponse response,HttpServletRequest request) throws Exception {
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
    @RequestMapping("/shoppingCart.shtml")
    public String shoppinglist(HttpSession session, HttpServletRequest request){
        if (session.getAttribute("shopping")!=null){
            HashMap map = (HashMap) session.getAttribute("shopping");
            //map key是商品的id value是商品的购物车添加次数
            Set set = map.keySet();
            Iterator it = set.iterator();
            List<Vo> list = new ArrayList<Vo>();
            while (it.hasNext()){
                //取到map的key
                String id = (String) it.next();
                //通过id把商品详情查出来
                Items items = itemsService.findItemsByIds(Integer.parseInt(id));
                Vo itemsVo = new Vo();
                itemsVo.setItems(items);
                int value = (int) map.get(id);
                itemsVo.setShoppingCount(value);
                list.add(itemsVo);
            }
            request.setAttribute("list",list);
        }
        return "shopcat";
    }
}
