package com.fc.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Hetong implements Serializable {
    private Integer id;

    private String chuzu;

    private String chuzuIdcard;

    private String zuke;

    private String zukeIdcard;

    private String fromdate;

    private String todate;

    private String houseId;

    private Integer payday;

    private Houselist houselist;
    private Userlist userlist;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChuzu() {
        return chuzu;
    }

    public void setChuzu(String chuzu) {
        this.chuzu = chuzu == null ? null : chuzu.trim();
    }

    public String getChuzuIdcard() {
        return chuzuIdcard;
    }

    public void setChuzuIdcard(String chuzuIdcard) {
        this.chuzuIdcard = chuzuIdcard == null ? null : chuzuIdcard.trim();
    }

    public String getZuke() {
        return zuke;
    }

    public void setZuke(String zuke) {
        this.zuke = zuke == null ? null : zuke.trim();
    }

    public String getZukeIdcard() {
        return zukeIdcard;
    }

    public void setZukeIdcard(String zukeIdcard) {
        this.zukeIdcard = zukeIdcard == null ? null : zukeIdcard.trim();
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate == null ? null : fromdate.trim();
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate == null ? null : todate.trim();
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public Integer getPayday() {
        return payday;
    }

    public void setPayday(Integer payday) {
        this.payday = payday;
    }
}