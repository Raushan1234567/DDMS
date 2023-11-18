package com.c3ihub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c3ihub.model.Dog;

public interface Drepository extends JpaRepository<Dog, Integer>{

	public Optional<Dog> findByName(String dogName);

	public void deleteByName(String dogName);

}
