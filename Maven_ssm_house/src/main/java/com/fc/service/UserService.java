package com.fc.service;

import com.fc.pojo.User;
import com.fc.pojo.Userlist;

import java.util.List;

public interface UserService {
    List<User> userList();

    User getUser(User user);

    User selectIdName(String username);
}
