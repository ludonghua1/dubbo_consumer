package com.yitian.mybatis.model;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;

    private String money;

    private Date createTime;

    private Integer status;

    private SysUser user;

    private Integer userId;

    private List<Items> itemsList;

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
        this.money = money == null ? null : money.trim();
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

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<Items> getItems() {
        return itemsList;
    }

    public void setItems(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", money='" + money + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", user=" + user +
                ", userId=" + userId +
                ", items=" + itemsList +
                '}';
    }
}