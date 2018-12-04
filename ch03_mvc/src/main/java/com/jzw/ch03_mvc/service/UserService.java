package com.jzw.ch03_mvc.service;

import com.jzw.ch03_mvc.entity.User;

import java.util.List;

public interface UserService {
    public List<User> allUser();

    public User getUser(int userId);

}