package com.walye.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.walye.entity.User;

@Component
public class UserDao extends BaseDao4Hibernate<User, Serializable> implements IUserDao{

}
