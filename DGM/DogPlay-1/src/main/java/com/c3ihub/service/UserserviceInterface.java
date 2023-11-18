package com.c3ihub.service;

import com.c3ihub.model.User;

public interface UserserviceInterface {

	public User add(User user);
	
	public User updateUser(User user,int userId);
	
}
