package com.fc.dao;

import com.fc.pojo.Hetong;
import com.fc.pojo.HetongExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HetongMapper {
    long countByExample(HetongExample example);

    int deleteByExample(HetongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hetong record);

    int insertSelective(Hetong record);

    List<Hetong> selectByExample(HetongExample example);

    Hetong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hetong record, @Param("example") HetongExample example);

    int updateByExample(@Param("record") Hetong record, @Param("example") HetongExample example);

    int updateByPrimaryKeySelective(Hetong record);

    int updateByPrimaryKey(Hetong record);

    Hetong showHeTong(@Param("houseId") String houseId);

    int deleteHeTong(@Param("houseId") String houseId);

    Hetong toAddZuList(String houseId);

    int addHeTong(Hetong hetong);
}