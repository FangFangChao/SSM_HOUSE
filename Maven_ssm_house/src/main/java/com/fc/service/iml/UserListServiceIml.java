package com.fc.service.iml;

import com.fc.dao.UserMapper;
import com.fc.dao.UserlistMapper;
import com.fc.pojo.User;
import com.fc.pojo.Userlist;
import com.fc.service.UserListService;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserListServiceIml implements UserListService {
    @Autowired
    UserlistMapper userlistMapper;

    @Override
    public List<Userlist> getUserList() {
        return userlistMapper.getUserList();
    }

    @Override
    public Userlist selectNameId(String name) {
        return userlistMapper.selectNameId(name);
    }

    @Override
    public List<Userlist> getUserListApply() {
        return userlistMapper.getUserListApply();
    }

    @Override
    public int updateUserList(Userlist userlist) {
        return userlistMapper.updateUserList(userlist);
    }

    @Override
    public Userlist selectUserlist(Integer id) {
        return userlistMapper.selectUserlist(id);
    }

    @Override
    public List<Userlist> myZuList() {
        return userlistMapper.myZuList();
    }
}
