package com.c3ihub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c3ihub.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	 Optional<User> findByEmail(String email);
}
