package com.web.business.lucky.service;

import java.util.List;

import com.web.business.lucky.dao.UserMapper1;
import com.web.business.lucky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	private UserMapper1 userMapper;

	public UserMapper1 getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper1 userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public List<User> getAll2() {
		return userMapper.getAll2();
	}

	@Override
	public List<User> getAll3() {
		return userMapper.getAll3();
	}

}
