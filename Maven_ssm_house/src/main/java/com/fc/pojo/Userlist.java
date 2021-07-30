package com.fc.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class Userlist extends UserlistKey implements Serializable {
    private String name;

    private String phone;

    private Integer userId;

    private Houselist houselist;

    private List<Zulist> zulist;

    public Houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(Houselist houselist) {
        this.houselist = houselist;
    }

    public List<Zulist> getZulist() {
        return zulist;
    }

    public void setZulist(List<Zulist> zulist) {
        this.zulist = zulist;
    }

    private User user;

    private Apply apply;

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}