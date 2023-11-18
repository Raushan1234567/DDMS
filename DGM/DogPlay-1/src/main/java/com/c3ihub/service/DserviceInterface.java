package com.c3ihub.service;

import java.util.List;

import com.c3ihub.model.Dog;

public interface DserviceInterface {
	
	public Dog addDog(Dog dog);

	public String getDog(String dogName);

	public List<Dog> getAllDog();

	public String deleteAll();

	public String delete(Integer dog_uniqueid);

	public Dog update(Integer dog_uniqueid, String name, String nature, String breed);

}
