package com.fc.service;

import com.fc.pojo.Applyout;
import com.fc.pojo.Wrong;

import java.util.List;

public interface WrongService {
    List<Wrong> wrongList();

    int updateWrong(String status, Integer id);

    int deleteWrong(Integer id);

    Wrong selectWrong(Integer id);
}
