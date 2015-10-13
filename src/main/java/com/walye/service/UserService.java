package com.walye.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.walye.dao.UserDao;
import com.walye.entity.User;

@Component
public class UserService implements IUserService{

	@Resource
	private UserDao userdao;

	public List<User> findAll() {
		return userdao.findAll();
	}

	public long addUser(User user) {
		return userdao.save(user);
	}

	public User findUserById(long id) {
		return userdao.findById(id);
	}

	public void updateUser(User user) {
		userdao.update(user);
	}

}
