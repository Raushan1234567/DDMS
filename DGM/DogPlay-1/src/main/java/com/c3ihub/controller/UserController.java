package com.c3ihub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c3ihub.model.User;
import com.c3ihub.model.UserDto;
import com.c3ihub.repository.UserRepository;
import com.c3ihub.service.UserserviceInterface;




@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserserviceInterface userser;
	@Autowired
	private UserRepository userRepository;

	
	  @PostMapping("/users")
	    public ResponseEntity<User> createUser(@RequestBody UserDto userDTO) {
	        
	        User newUser = new User();
	        newUser.setName(userDTO.getName());
	        newUser.setEmail(userDTO.getEmail());
	        newUser.setPassword(userDTO.getPassword());
	        newUser.setUserRole(userDTO.getUserRole());
	        newUser.setAddress(userDTO.getAddress());
	        newUser.setMobNumber(userDTO.getMobNumber());

	        return new ResponseEntity<User>(userser.add(newUser), HttpStatus.CREATED);
	    }
	




}
