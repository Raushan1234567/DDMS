package com.c3ihub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c3ihub.model.User;
import com.c3ihub.repository.UserRepository;

@Service
public class UserserviceImple implements UserserviceInterface{

	@Autowired
	private UserRepository userrepository;
	
	
	@Override
	public User add(User user) {
		
		return userrepository.save(user);
	}

	@Override
	public User updateUser(User user, int userId) {
		
		return null;
	}

}
