package com.neusoft.service.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.model.UserT;
import com.neusoft.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
	@Override
	public UserT findUserByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(userName);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
