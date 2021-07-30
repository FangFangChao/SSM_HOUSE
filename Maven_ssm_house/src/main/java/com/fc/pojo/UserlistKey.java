package com.fc.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserlistKey implements Serializable {
    private Integer id;

    private String idcard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }
}