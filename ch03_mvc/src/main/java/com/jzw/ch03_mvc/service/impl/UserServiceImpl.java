package com.jzw.ch03_mvc.service.impl;

import com.jzw.ch03_mvc.entity.User;
import com.jzw.ch03_mvc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public List<User> allUser() {
        List<User> users = new ArrayList<User>();
        for(int i = 0; i < 10; i ++){
            users.add(new User(i,"张三"+i));
        }
        return users;
    }

    @Override
    public User getUser(int userId) {
        User user = new User(userId,"李四"+userId);
        return user;
    }
}
