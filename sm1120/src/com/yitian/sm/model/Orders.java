package com.yitian.sm.model;


import com.yitian.sm.vo.ItemsVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable {
    private SysUser user;

    private Integer id;

    private String money;

    private Date createTime;

    private String status;

    private Integer userId;



    private List<ItemsVo> itemsVo;

    public List<ItemsVo> getItemsVo() {
        return itemsVo;
    }

    public void setItemsVo(List<ItemsVo> itemsVo) {
        this.itemsVo = itemsVo;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId(Integer id) {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", money='" + money + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}