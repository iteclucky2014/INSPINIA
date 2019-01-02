package com.web.business.login.dao;

import com.web.business.login.model.User;

public interface UserMapper {

	User selectByPrimaryKey(int id);
	
	User selectByName(String name);
	
	int deleteByPrimaryKey(int id);

	int insert(User user);

//	int insertSelective(User user);

	int updateByPrimaryKeySelective(User user);

//	int updateByPrimaryKey(User user);
}