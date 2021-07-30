package com.fc.service;

import com.fc.pojo.Houselist;
import com.fc.pojo.Userlist;

import java.util.List;

public interface HouseListService {
    List<Houselist> showHouseList();

    int insert(Houselist record);

    int deleteByPrimaryKey(Houselist key);

    int updateByPrimaryKey(Houselist record);

    Houselist getHouseInfo(Houselist record);

    int updateStatus(String status, String houseid);

    Houselist selectByprimary(Integer id);
}
