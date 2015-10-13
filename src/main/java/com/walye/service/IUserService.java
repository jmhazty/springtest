package com.walye.service;

import java.util.List;

import com.walye.entity.User;

public interface IUserService {

	public List<User> findAll();

	public long addUser(User user);

	public User findUserById(long id);

	public void updateUser(User user);
}
