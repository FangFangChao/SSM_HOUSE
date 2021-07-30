package com.fc.pojo;

import java.io.Serializable;
import java.util.List;

public class Applyout implements Serializable {
    private Integer aoid;

    private Integer houseId;

    private Integer userlistId;


    private Houselist houselist;

    private List<Userlist> userlist;


    public Houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(Houselist houselist) {
        this.houselist = houselist;
    }


    public List<Userlist> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<Userlist> userlist) {
        this.userlist = userlist;
    }

    public Integer getAoid() {
        return aoid;
    }

    public void setAoid(Integer aoid) {
        this.aoid = aoid;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserlistId() {
        return userlistId;
    }

    public void setUserlistId(Integer userlistId) {
        this.userlistId = userlistId;
    }
}