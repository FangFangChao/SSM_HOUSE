package com.fc.service;

import com.fc.pojo.User;
import com.fc.pojo.Userlist;

import java.util.List;

public interface UserListService {
    List<Userlist> getUserList();

    Userlist selectNameId(String name);

    List<Userlist> getUserListApply();

    int updateUserList(Userlist userlist);

    Userlist selectUserlist(Integer id);

    List<Userlist> myZuList();
}
