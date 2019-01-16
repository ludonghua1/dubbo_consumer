package com.yitian.ldh.model;

import java.util.Date;

public class Company {
    private Integer id;

    private String companycode;

    private String companyname;

    private String address;

    private Integer procince;

    private Integer city;

    private Integer contry;

    private String tel1;

    private String tel2;

    private String phone;

    private String main;

    private String singleBrand;

    private String singleParts;

    private String prime;

    private String leader;

    private String memo;

    private Date createtime;

    private String picurl1;

    private String picurl2;

    private String picurl3;

    private String picurl4;

    private Integer delstatus;

    private String qq;

    private String zone1;

    private String zone2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode == null ? null : companycode.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getProcince() {
        return procince;
    }

    public void setProcince(Integer procince) {
        this.procince = procince;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getContry() {
        return contry;
    }

    public void setContry(Integer contry) {
        this.contry = contry;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1 == null ? null : tel1.trim();
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2 == null ? null : tel2.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main == null ? null : main.trim();
    }

    public String getSingleBrand() {
        return singleBrand;
    }

    public void setSingleBrand(String singleBrand) {
        this.singleBrand = singleBrand == null ? null : singleBrand.trim();
    }

    public String getSingleParts() {
        return singleParts;
    }

    public void setSingleParts(String singleParts) {
        this.singleParts = singleParts == null ? null : singleParts.trim();
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime == null ? null : prime.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPicurl1() {
        return picurl1;
    }

    public void setPicurl1(String picurl1) {
        this.picurl1 = picurl1 == null ? null : picurl1.trim();
    }

    public String getPicurl2() {
        return picurl2;
    }

    public void setPicurl2(String picurl2) {
        this.picurl2 = picurl2 == null ? null : picurl2.trim();
    }

    public String getPicurl3() {
        return picurl3;
    }

    public void setPicurl3(String picurl3) {
        this.picurl3 = picurl3 == null ? null : picurl3.trim();
    }

    public String getPicurl4() {
        return picurl4;
    }

    public void setPicurl4(String picurl4) {
        this.picurl4 = picurl4 == null ? null : picurl4.trim();
    }

    public Integer getDelstatus() {
        return delstatus;
    }

    public void setDelstatus(Integer delstatus) {
        this.delstatus = delstatus;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getZone1() {
        return zone1;
    }

    public void setZone1(String zone1) {
        this.zone1 = zone1 == null ? null : zone1.trim();
    }

    public String getZone2() {
        return zone2;
    }

    public void setZone2(String zone2) {
        this.zone2 = zone2 == null ? null : zone2.trim();
    }
}