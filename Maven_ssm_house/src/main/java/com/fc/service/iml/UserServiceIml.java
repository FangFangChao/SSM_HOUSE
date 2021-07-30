package com.fc.service.iml;

import com.fc.dao.UserMapper;
import com.fc.pojo.User;
import com.fc.pojo.Userlist;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public User selectIdName(String username) {
        return userMapper.selectIdName(username);
    }
}
