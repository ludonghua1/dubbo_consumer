package com.yitian.ssm.controller;

import com.yitian.ssm.model.Items;
import com.yitian.ssm.model.SysUser;
import com.yitian.ssm.model.Vo;
import com.yitian.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class ShoppingController {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private JedisCluster jedis;
    @RequestMapping("/shopping.shtml")
    public void shoping(String ids,HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies=request.getCookies();
        String token = "";
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")){
                token=cookie.getValue();
            }
            break;
        }
        String userId = jedis.hget(token,"id");
        //获取jedis的shoppingKey
        String shoppingKey = "shopping:"+userId;
        String[] array = ids.split(",");
        if (token!=null){
            for (String id :array) {
                 //判断jedis的key存在
                if (jedis.exists(shoppingKey)){
                    //jedis自增1
                    jedis.hincrBy(shoppingKey,id,1);
                }else {
                    //如果jedis的key不存在，存入
                    jedis.hset(shoppingKey,id, "1");
                }
            }
            response.getWriter().write("success");
        }else {
            response.getWriter().write("1");
        }
    }
    @RequestMapping("/shoppingCart.shtml")
    public String shoppinglist(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        String token = "";
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")){
                token=cookie.getValue();
            }
            break;
        }
        String userId = jedis.hget(token,"id");
        //获取jedis的shoppingKey
        String shoppingKey = "shopping:"+userId;
        //System.out.println(userId);
        HashMap<String,String> map = (HashMap<String, String>) jedis.hgetAll(shoppingKey);
            Set set = map.keySet();
            Iterator it = set.iterator();
            List<Vo> list = new ArrayList<Vo>();
            while (it.hasNext()){
                //取到map的key
                String id = (String) it.next();
                //通过id把商品详情查出来
                Items items = itemsService.findItemsByIds(Integer.parseInt(id));
                Vo vo = new Vo();
                vo.setItems(items);
                int value = Integer.parseInt(map.get(id));
                vo.setShoppingCount(value);
                list.add(vo);
        }
        request.setAttribute("list",list);
        return "shopcat";
    }
    @RequestMapping("/delshopping.shtml")
    public void delshopping(String ids,HttpServletRequest request,HttpServletResponse response) throws Exception {
        Cookie[] cookies=request.getCookies();
        String token = "";
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")){
                token=cookie.getValue();
            }
            break;
        }
        //获取用户id
        String userId = jedis.hget(token,"id");
        //获取jedis的shoppingKey
        String shoppingKey = "shopping:"+userId;
        if (token!=null) {
            //获取jedis的全部key存入map
            HashMap map = (HashMap) jedis.hgetAll(userId);
            String[] array = ids.split(",");
            for (String id : array) {
                if (map.containsKey(id)) {
                    //删除jedis的key对应的ID的值
                    jedis.hdel(userId,id);
                }
            }
            response.getWriter().write("success");
        }else {
            response.getWriter().write("1");
        }
    }
}
