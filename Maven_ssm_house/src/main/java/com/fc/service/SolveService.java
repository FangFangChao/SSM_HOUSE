package com.fc.service;

import com.fc.pojo.Applyout;
import com.fc.pojo.Solve;

import java.util.Date;
import java.util.List;

public interface SolveService {
    List<Solve> selectAll();

    int insertSolve(String houseId, Date date, String detail, Integer userlistId, String status);

    List<Solve> selectAllSubmit(String zuname, String fromdate, String todate);

    int deleteSolve(Integer id);
}
