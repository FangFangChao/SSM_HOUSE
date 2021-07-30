package com.fc.service;

import com.fc.pojo.Apply;
import com.fc.pojo.Checkout;

import java.util.List;

public interface ApplyService {

    List<Apply> findAllApply();

    int deleteapply(String houseId);

    int insertApply(String houseid, Integer id);
}
