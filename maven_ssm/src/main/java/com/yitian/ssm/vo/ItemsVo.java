package com.yitian.ssm.vo;

import com.yitian.ssm.model.Items;
import com.yitian.ssm.model.Orders;

public class ItemsVo {
    private String itemsName;
    private String minPrice;
    private String maxPrice;
    private Orders orders;
    private Items items;
    private int shoppingCount;
    private long leftCount;
    private int Count;
    private long leftTime;

    public long getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(long leftCount) {
        this.leftCount = leftCount;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public long getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(long leftTime) {
        this.leftTime = leftTime;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getShoppingCount() {
        return shoppingCount;
    }

    public void setShoppingCount(int shoppingCount) {
        this.shoppingCount = shoppingCount;
    }
}
