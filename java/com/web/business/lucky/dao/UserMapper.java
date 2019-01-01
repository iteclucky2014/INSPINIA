package com.web.business.lucky.dao;

import java.util.List;

import com.web.business.lucky.model.User;

public interface UserMapper {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> getAll();

	List<User> getAll2();

	List<User> getAll3();
}