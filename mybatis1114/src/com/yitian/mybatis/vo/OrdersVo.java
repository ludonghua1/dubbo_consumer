package com.yitian.mybatis.vo;

import java.util.Date;

public class OrdersVo {
    private int id;
    private String money;
    private Date createTime;
    private int status;
    private String loginName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "OrdersVo{" +
                "id=" + id +
                ", money='" + money + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}
