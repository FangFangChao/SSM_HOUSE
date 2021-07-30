package com.fc.service.iml;

import com.fc.dao.ApplyoutMapper;
import com.fc.dao.SolveMapper;
import com.fc.pojo.Applyout;
import com.fc.pojo.Solve;
import com.fc.service.ApplyoutService;
import com.fc.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SolveServiceIml implements SolveService {
    @Autowired
    SolveMapper solveMapper;

    @Override
    public List<Solve> selectAll() {
        return solveMapper.selectAll();
    }

    @Override
    public int insertSolve(String houseId, Date date, String detail, Integer userlistId, String status) {
        return solveMapper.insertSolve(houseId, date, detail, userlistId, status);
    }

    @Override
    public List<Solve> selectAllSubmit(String zuname, String fromdate, String todate) {
        return solveMapper.selectAllSubmit(zuname, fromdate, todate);
    }

    @Override
    public int deleteSolve(Integer id) {
        return solveMapper.deleteByPrimaryKey(id);
    }
}
