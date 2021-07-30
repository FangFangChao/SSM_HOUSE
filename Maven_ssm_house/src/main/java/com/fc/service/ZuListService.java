package com.fc.service;


import com.fc.pojo.Apply;
import com.fc.pojo.Houselist;
import com.fc.pojo.Zulist;

import java.util.List;

public interface ZuListService {
    List<Zulist> showZuList();

    int insertZulist(String houseId, Integer userlistId, int contractId);

    int deleteZulist(String houseId);

    Zulist selectZulist(Integer zid);
}
