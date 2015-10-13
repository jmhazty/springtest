package com.walye.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.walye.entity.User;
@Component
public class QuestionService implements IQuestionService{
	@Resource
	private IUserService userService;
	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		User user = userService.findUserById(id);
		return user;
	}

}
