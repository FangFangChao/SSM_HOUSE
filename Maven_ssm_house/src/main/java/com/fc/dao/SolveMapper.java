package com.fc.dao;

import com.fc.pojo.Solve;
import com.fc.pojo.SolveExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SolveMapper {
    long countByExample(SolveExample example);

    int deleteByExample(SolveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Solve record);

    int insertSelective(Solve record);

    List<Solve> selectByExampleWithBLOBs(SolveExample example);

    List<Solve> selectByExample(SolveExample example);

    Solve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Solve record, @Param("example") SolveExample example);

    int updateByExampleWithBLOBs(@Param("record") Solve record, @Param("example") SolveExample example);

    int updateByExample(@Param("record") Solve record, @Param("example") SolveExample example);

    int updateByPrimaryKeySelective(Solve record);

    int updateByPrimaryKeyWithBLOBs(Solve record);

    int updateByPrimaryKey(Solve record);

    List<Solve> selectAll();

    int insertSolve(
            @Param("houseId") String houseId,
            @Param("date") Date date,
            @Param("detail") String detail,
            @Param("userlistId") Integer userlistId,
            @Param("status") String status);

    List<Solve> selectAllSubmit(@Param("zuke") String zuke, @Param("fromdate") String fromdate, @Param("todate") String todate);
}