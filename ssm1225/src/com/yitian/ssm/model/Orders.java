package com.yitian.ssm.model;

import com.yitian.ssm.vo.ItemsVo;

import java.util.Date;

public class Orders {
    private Integer id;

    private String money;

    private Date createTime;

    private Integer status;

    private Integer userId;

    private Items items;

    private ItemsVo itemsVo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsVo getItemsVo() {
        return itemsVo;
    }

    public void setItemsVo(ItemsVo itemsVo) {
        this.itemsVo = itemsVo;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", money='" + money + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", userId=" + userId +
                ", items=" + items +
                ", itemsVo=" + itemsVo +
                '}';
    }
}