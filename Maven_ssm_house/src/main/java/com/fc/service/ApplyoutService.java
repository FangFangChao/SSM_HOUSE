package com.fc.service;

import com.fc.pojo.Applyout;

import java.util.List;

public interface ApplyoutService {

    List<Applyout> findAllApplyout();

    int deleteApplyout(String houseId);

    int insertapplyout(Integer houseId, Integer id);
}
