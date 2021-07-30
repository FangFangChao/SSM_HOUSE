package com.fc.service;

import com.fc.pojo.Apply;
import com.fc.pojo.Hetong;
import com.fc.pojo.Houselist;
import com.fc.pojo.User;

import java.util.List;

public interface HetongService {
    Hetong showHeTong(String houseId);

    int deleteHeTong(String houseId);

    int updateHeTong(Hetong hetong1);

    Hetong toAddZuList(String houseId);

    int addHeTong(Hetong hetong);
}
