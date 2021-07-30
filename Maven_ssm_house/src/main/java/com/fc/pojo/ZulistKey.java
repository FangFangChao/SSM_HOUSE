package com.fc.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Component
public class ZulistKey implements Serializable {
    private Integer zid;

    private String houseId;

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }
}