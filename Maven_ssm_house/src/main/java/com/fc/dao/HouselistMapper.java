package com.fc.dao;

import com.fc.pojo.Houselist;
import com.fc.pojo.HouselistExample;
import com.fc.pojo.HouselistKey;

import java.util.List;

import com.fc.pojo.Userlist;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

public interface HouselistMapper {
    long countByExample(HouselistExample example);

    int deleteByExample(HouselistExample example);

    int deleteByPrimaryKey(HouselistKey key);

    int insert(Houselist record);

    int insertSelective(Houselist record);

    List<Houselist> selectByExample(HouselistExample example);

    Houselist selectByPrimaryKey(HouselistKey key);

    int updateByExampleSelective(@Param("record") Houselist record, @Param("example") HouselistExample example);

    int updateByExample(@Param("record") Houselist record, @Param("example") HouselistExample example);

    int updateByPrimaryKeySelective(Houselist record);

    int updateByPrimaryKey(Houselist record);

    List<Houselist> showHouseList();

    int updateStatus(@Param("status") String status, @Param("houseid") String houseid);

    Houselist selectByprimary(Integer id);
}