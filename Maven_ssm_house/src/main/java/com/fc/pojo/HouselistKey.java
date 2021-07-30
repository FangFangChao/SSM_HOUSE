package com.fc.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class HouselistKey implements Serializable {
    private Integer id;

    private String houseid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid == null ? null : houseid.trim();
    }
}