package com.yitian.ssm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yitian.ssm.model.Items;
import com.yitian.ssm.model.Vo;
import com.yitian.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
public class CookieController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/cookie.shtml")
    public void cookie(String ids, HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Items> list = itemsService.findByIds(ids);//根据id查商品
        Cookie[] cookies = request.getCookies();//获取cookie
        String itemsJsonArray = null;
        Boolean jsonArray = false;
        //循环遍历cookie是否存在
        for (Cookie cookie:cookies){
            if ("shopping".equals(cookie.getName())){
            //如果不存在，获取cookie对应的值
                itemsJsonArray=cookie.getValue();
                jsonArray = true;
                break;
            }
        }
        //判断cookie，如果cookie不存在
        if(!jsonArray){
            List<Vo> itemsVoList = new ArrayList<Vo>();
            //循环商品，将商品和数量添加到itemsVo中
            for (Items items:list){
                Vo itemsVo = new Vo();
                itemsVo.setItems(items);
                itemsVo.setShoppingCount(1);
                itemsVoList.add(itemsVo);
            }

            //将itemsVo对象转为字符串
            String jsonString = com.alibaba.fastjson.JSON.toJSONString(itemsVoList);
            //将json字符串进行编码
            jsonString = URLEncoder.encode(jsonString, "UTF-8");
            //创建cookie，把编码的字符串存入cookie
            Cookie cookie = new Cookie("shopping",jsonString);
            //添加到cookie中
            response.addCookie(cookie);
            response.getWriter().write("1");
        }else {
            itemsJsonArray = URLDecoder.decode(itemsJsonArray, "UTF-8");
            List<Vo> itemsList = com.alibaba.fastjson.JSON.parseArray(itemsJsonArray,Vo.class);
            for (Items items:list){
                boolean c = true;
                //循环itemsVo集合
                for (Vo itemsVo:itemsList){
                    int count =itemsVo.getShoppingCount();
                    //判断商品id与cookie的id相等，商品数量加1
                    if (itemsVo.getItems().getId()==items.getId()){
                        count++;
                        System.out.println(count);
                        itemsVo.setShoppingCount(count);
                        c = false;
                    }
                }
                //cookie中没有商品id，将商品存入cookie中
                if (c){
                    Vo itemsVo =new Vo();
                    itemsVo.setShoppingCount(1);
                    itemsVo.setItems(items);
                    itemsList.add(itemsVo);
                }
            }
            //将itemsVo对象转为字符串
            String itemsVoListJson = com.alibaba.fastjson.JSON.toJSONString(itemsList);
            //将json字符串进行编码
            itemsVoListJson = URLEncoder.encode(itemsVoListJson,"utf-8");
            //创建cookie，把编码的字符串存入cookie
            Cookie cookie = new Cookie("shopping",itemsVoListJson);
            //添加到cookie中
            response.addCookie(cookie);
            response.getWriter().write("1");
        }
    }

    @RequestMapping("/shoppinglist.shtml")
    public String shoppingCart(HttpServletRequest request) throws UnsupportedEncodingException {
        //获取cookie
        Cookie[] cookies = request.getCookies();
        String jsonArray = null;
        for (Cookie cookie:cookies){
            //取出cookie对应的值
            if ("shopping".equals(cookie.getName())){
                jsonArray=cookie.getValue();
            }
        }
        if (jsonArray!=null){
        //如果json字符串不为空，将json解码
            jsonArray = URLDecoder.decode(jsonArray, "UTF-8");
            //将json数组转为itemsVo集合
            List<Vo> itemsList = com.alibaba.fastjson.JSON.parseArray(jsonArray,Vo.class);
            request.setAttribute("list",itemsList);
        }
        return "shopcat";
    }
    @RequestMapping("/delCookieShopping.shtml")
    public void delCookieShoppingCart(HttpServletRequest request, String ids, HttpServletResponse response) throws IOException {

        String[] id = ids.split(",");
        //取cookie数组对应的值
        Cookie[] array = request.getCookies();
        List<Vo> itemsVoList = new ArrayList<Vo>();
        //循环遍历cookie数组
        for (Cookie cookie : array) {
            if (cookie.getName().equals("shopping")) {
                //判断cookie对应的值
                 String itemsVOJSON = cookie.getValue();
                itemsVOJSON = URLDecoder.decode(itemsVOJSON, "UTF-8");
                itemsVoList = JSONArray.parseArray(itemsVOJSON, Vo.class);
            }
        }
        //迭代itemsVo
        Iterator<Vo> it = itemsVoList.iterator();
        for (String sid:id){
            //将id转为整形
            int iid = Integer.parseInt(sid);
            //遍历id
            while (it.hasNext()){
                //判断商品id是否存在
                if (it.next().getItems().getId()==iid){
                    it.remove();
                    break;
                }
            }
        }
            String itemsVoListJ = JSON.toJSONString(itemsVoList);
            itemsVoListJ = URLEncoder.encode(itemsVoListJ, "UTF-8");
            Cookie cookie = new Cookie("shopping", itemsVoListJ);
            response.addCookie(cookie);
        response.getWriter().write("1");
    }

}
