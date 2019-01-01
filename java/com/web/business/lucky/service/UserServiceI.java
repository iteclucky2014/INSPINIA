package com.web.business.lucky.service;

import com.web.business.lucky.model.User;

import java.util.List;

public interface UserServiceI {

	User getUserById(String id);

	List<User> getAll();

	List<User> getAll2();

	List<User> getAll3();

}
