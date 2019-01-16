package com.yitian.ldh.model;

import java.util.Date;

public class Collections {
    private Integer id;

    private Integer colletorid;

    private Integer colletedid;

    private Integer itemsid;

    private Date createtime;

    private Integer delstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getColletorid() {
        return colletorid;
    }

    public void setColletorid(Integer colletorid) {
        this.colletorid = colletorid;
    }

    public Integer getColletedid() {
        return colletedid;
    }

    public void setColletedid(Integer colletedid) {
        this.colletedid = colletedid;
    }

    public Integer getItemsid() {
        return itemsid;
    }

    public void setItemsid(Integer itemsid) {
        this.itemsid = itemsid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDelstatus() {
        return delstatus;
    }

    public void setDelstatus(Integer delstatus) {
        this.delstatus = delstatus;
    }
}