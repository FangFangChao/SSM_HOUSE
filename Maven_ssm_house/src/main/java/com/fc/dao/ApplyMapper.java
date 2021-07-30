package com.fc.dao;

import com.fc.pojo.Apply;
import com.fc.pojo.ApplyExample;
import com.fc.pojo.ApplyKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
    long countByExample(ApplyExample example);

    int deleteByExample(ApplyExample example);

    int deleteByPrimaryKey(ApplyKey key);

    int insert(Apply record);

    int insertSelective(Apply record);

    List<Apply> selectByExample(ApplyExample example);

    Apply selectByPrimaryKey(ApplyKey key);

    int updateByExampleSelective(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByExample(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    List<Apply> findAllApply();

    int deleteapply(String houseId);

    int insertApply(@Param("houseid") String houseid, @Param("userlistId") Integer id);
}