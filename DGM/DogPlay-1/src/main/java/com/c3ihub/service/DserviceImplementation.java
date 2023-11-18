package com.c3ihub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c3ihub.exception.DogNotFoundException;
import com.c3ihub.model.Dog;
import com.c3ihub.repository.Drepository;

@Service
public class DserviceImplementation implements DserviceInterface{
	@Autowired
	private Drepository drepository;
	
	@Override
	public Dog addDog(Dog dog) {
		
		return drepository.save(dog);
	}

	@Override
	public String getDog(String dogName) {
		
		Optional<Dog> dn=drepository.findByName(dogName);
		String s="Dog Breed ="+dn.get().getBreed()+ ", Dog Nature=" +dn.get().getNature();
		return s;
		
	}

	@Override
	public List<Dog> getAllDog() {
		
		return drepository.findAll();
	}

	@Override
	public String deleteAll() {
		
		drepository.deleteAll();
		return "All the dogs data deleted";
	}

	@Override
	public String delete(Integer dog_uniqueid) {
	    Optional<Dog> optionalDog = drepository.findById(dog_uniqueid);

	    if (optionalDog.isPresent()) {
	        Dog dog = optionalDog.get();
	        drepository.deleteById(dog.getDog_uniqueid());
	        return dog_uniqueid + " the dog's data deleted";
	    } else {
	        throw new DogNotFoundException("Dog with name " + dog_uniqueid + " not found");
	    }
	}

	@Override
	public Dog update(Integer dog_uniqueid, String name, String nature, String breed) {
		Optional<Dog> t=drepository.findById(dog_uniqueid);
		
		Dog r=t.get();
		r.setName(name);
		r.setNature(nature);
		r.setBreed(breed);
		drepository.save(r);
		return r;
	}

	

}
