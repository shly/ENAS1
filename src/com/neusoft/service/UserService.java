package com.neusoft.service;

import com.neusoft.model.UserT;

public interface UserService {
	public UserT findUserByName(String userName);
}
