package com.yitian.ssm.controller;

import com.yitian.ssm.model.Items;
import com.yitian.ssm.model.Orders;
import com.yitian.ssm.model.OrdersItemsRelation;
import com.yitian.ssm.service.ItemsService;
import com.yitian.ssm.service.OrdersItemsRelationService;
import com.yitian.ssm.service.OrdersService;
import com.yitian.ssm.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FlashSaleController {
    @Autowired
    private JedisCluster jedisCluster;
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersItemsRelationService ordersItemsRelationService;


    /**
     * 在抢购的页面
     * 1.需要知道抢购商品的一些信息：商品图片，商品名称，商品价格
     * 2.需要知道抢购商品的总库存数和剩余库存数
     * 3.需要知道该商品开始抢购的时间
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/toFlashSale.shtml")
    public String toFalshSale(HttpServletRequest request) throws Exception {
        //获取所有的抢购商品
        Map<String, String> map = jedisCluster.hgetAll("flashSale");
        //将来为了遍历要抢购的商品
        List<ItemsVo> itemsVoList = new ArrayList<ItemsVo>();
        //判断一下有没有要抢购的商品，如果有则运行if中的代码
        if (!map.isEmpty()) {
            //获取到所有抢购商品的id
            Set<String> idSet = map.keySet();
            Iterator<String> it = idSet.iterator();
            String startTime;
            //遍历商品id
            while (it.hasNext()) {
                String itemsId = it.next();  //商品的id
                //获取到该抢购商品的库存
                String total = jedisCluster.get("total:" + itemsId);
                //获取到该抢购商品的剩余数量
                long leftCount = jedisCluster.llen("list:" + itemsId);
                //获取到该商品开始抢购的时间
                startTime = map.get(itemsId);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long lstartTime = sdf.parse(startTime).getTime() /1000;
                long currentTime = new Date().getTime() /1000;
                //leftTime--剩余时间，距离开始抢购还有多少时间
                long leftTime = lstartTime - currentTime;
                ItemsVo itemsVo = new ItemsVo();
                itemsVo.setLeftCount(leftCount);
                itemsVo.setCount(Integer.parseInt(total));
                itemsVo.setLeftTime(leftTime);
                //通过商品id查询到商品信息
                Items items = itemsService.findItemsById(Integer.parseInt(itemsId));
                itemsVo.setItems(items);
                itemsVoList.add(itemsVo);
            }
            request.setAttribute("list", itemsVoList);
            request.setAttribute("msg", 1);
        } else {
            request.setAttribute("msg", 0);
        }
        return "flashsale";
    }

    /**
     * 用户要抢购的商品id
     * 再次判断是否到了抢购开始时间
     * 该用户的信息：用户名、用户id
     * 该用户是否已经抢购过了
     * 库存还有没有商品
     *
     * @param id
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/flashSale.shtml")
    public void flashSale(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //通过传进来的商品的id，从redis cluster集群中获取到抢购开始时间startTime
        Map<String, String> flashMap = jedisCluster.hgetAll("flashSale");
        String startTime = flashMap.get(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lstartTime = sdf.parse(startTime).getTime() / 1000;
        long currentTime = new Date().getTime() / 1000;
        long leftTime = lstartTime - currentTime;
        //当前时间已经过了开始抢购的时间
        if (leftTime < 0) {
            Cookie[] cookies = request.getCookies();
            //获取用户的id
            String userId = "";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    String login = cookie.getValue();
                    userId = jedisCluster.hget(login, "id");
                    System.out.println(userId+"++++++++++++++++++++++++++++");
                    break;
                }
            }
            //当前商品的总库存数
            int total = Integer.parseInt(jedisCluster.get("total:" + id));
            String itemsNo;    //商品序列号
            //遍历已经抢到该商品的用户id
            List<String> list = jedisCluster.lrange("flashusers:" + id, 0, -1);
            boolean check = false;
            if (list != null) {
                for (String itemsId : list) {
                    //判断该用户是否已经抢到商品了
                    if (itemsId.equals(userId)) {
                        check = true;
                    }
                }
            }
            if (check) {
                response.getWriter().write("3");
            } else {
                //有剩余
                if ((itemsNo = jedisCluster.lpop("list:" + id)) != null) {
                    jedisCluster.rpush("flashusers:" + id, userId);
                    response.getWriter().write("2");
                } else {
                    response.getWriter().write("1");
                }
            }
        } else {
            response.getWriter().write("0");
        }
    }

    @RequestMapping("/flashSaleOrders.shtml")
    public String flashSaleOrders(String id, HttpServletRequest request, HttpServletResponse response) {
        //获取登录用户的id
        Cookie[] cookies = request.getCookies();
        String userId = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                String login = cookie.getValue();  //查用户信息
                userId = jedisCluster.hget(login, "id");
                break;
            }
        }
        //去redis cluster集群里面取一下该用户抢购此商品的订单号
        //Map<"orders:"+id,HashMap<userId,Orders>>
        String orderId = jedisCluster.hget("orders:" + id, userId);
        if (orderId == null || orderId == "") {
            //生成订单
            Orders orders = new Orders();
            orders.setUserId(Integer.parseInt(userId));
            Items items = itemsService.findItemsById(Integer.parseInt(id));
            orders.setMoney(items.getPrice());
            orders.setStatus(1);
            Date date = new Date();
            orders.setCreateTime(date);
            //往订单商品关系表里添加信息
            OrdersItemsRelation ordersItemsRelation = new OrdersItemsRelation();
            ordersItemsRelation.setOrdersId(orders.getId());
            ordersItemsRelation.setItemsId(Integer.parseInt(id));
            ordersItemsRelation.setCount(1);
            ordersItemsRelationService.addRelation(orders,ordersItemsRelation);
            //将抢购商品的订单存到redis cluster集群
            jedisCluster.hset("orders:" + id, userId, orders.getId() + "");
            //展示订单
            Orders orders1 = ordersService.findOrdersAndItemsById(orders.getId());
            request.setAttribute("orders", orders1);
        }else{
            //如果已经有订单了，就直接展示订单即可
            Orders orders1 = ordersService.findOrdersAndItemsById(Integer.parseInt(orderId));
            System.out.println(orders1);
            request.setAttribute("orders", orders1);
        }
        return "orders";
    }

}
