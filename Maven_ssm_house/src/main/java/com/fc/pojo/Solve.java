package com.fc.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Solve implements Serializable {
    private Integer id;

    private String houseId;

    private Date date;

    private Integer userlistId;

    private String status;

    private String detail;

    private Hetong hetong;

    private Userlist userlist;

    private Houselist houselist;

    public Userlist getUserlist() {
        return userlist;
    }

    public Houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(Houselist houselist) {
        this.houselist = houselist;
    }

    public void setUserlist(Userlist userlist) {
        this.userlist = userlist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserlistId() {
        return userlistId;
    }

    public void setUserlistId(Integer userlistId) {
        this.userlistId = userlistId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}