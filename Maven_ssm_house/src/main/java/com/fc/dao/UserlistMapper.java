package com.fc.dao;

import com.fc.pojo.User;
import com.fc.pojo.Userlist;
import com.fc.pojo.UserlistExample;
import com.fc.pojo.UserlistKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserlistMapper {
    long countByExample(UserlistExample example);

    int deleteByExample(UserlistExample example);

    int deleteByPrimaryKey(UserlistKey key);

    int insert(Userlist record);

    int insertSelective(Userlist record);

    List<Userlist> selectByExample(UserlistExample example);

    Userlist selectByPrimaryKey(UserlistKey key);

    int updateByExampleSelective(@Param("record") Userlist record, @Param("example") UserlistExample example);

    int updateByExample(@Param("record") Userlist record, @Param("example") UserlistExample example);

    int updateByPrimaryKeySelective(Userlist record);

    int updateByPrimaryKey(Userlist record);

    List<Userlist> getUserList();

    Userlist selectNameId(String name);

    List<Userlist> getUserListApply();

    int updateUserList(Userlist userlist);

    Userlist selectUserlist(@Param("userId") Integer id);

    List<Userlist> myZuList();
}