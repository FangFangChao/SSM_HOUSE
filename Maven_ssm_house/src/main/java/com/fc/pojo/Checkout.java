package com.fc.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Checkout implements Serializable {
    private Integer cid;
    private Userlist userlist;
    private Houselist houselist;
    private String houseId;

    private Integer userlistId;

    public Userlist getUserlist() {
        return userlist;
    }

    public void setUserlist(Userlist userlist) {
        this.userlist = userlist;
    }

    public Houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(Houselist houselist) {
        this.houselist = houselist;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public Integer getUserlistId() {
        return userlistId;
    }

    public void setUserlistId(Integer userlistId) {
        this.userlistId = userlistId;
    }
}