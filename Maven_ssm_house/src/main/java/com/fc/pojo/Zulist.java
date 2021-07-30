package com.fc.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Zulist extends ZulistKey implements Serializable {
    private Integer userlistId;

    private Userlist userlist;

    private Houselist houselist;

    private Integer contractId;

    public Houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(Houselist houselist) {
        this.houselist = houselist;
    }

    public Userlist getUserlist() {
        return userlist;
    }

    public void setUserlist(Userlist userlist) {
        this.userlist = userlist;
    }

    public Integer getUserlistId() {
        return userlistId;
    }

    public void setUserlistId(Integer userlistId) {
        this.userlistId = userlistId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}