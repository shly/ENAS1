package com.neusoft.dao;

import com.neusoft.model.UserT;

public interface UserDao {
	
	public UserT findUserByName(String userName);

}
