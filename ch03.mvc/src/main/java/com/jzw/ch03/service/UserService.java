package com.jzw.ch03.service;


import com.jzw.ch03.entity.User;

import java.util.List;

public interface UserService {
	public List<User> allUser();
	public User getUserById(Long id);
	public void updateUser(Long id, Integer type);
}
