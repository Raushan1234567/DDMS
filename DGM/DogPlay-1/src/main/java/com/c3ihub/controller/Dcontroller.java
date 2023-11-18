package com.c3ihub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c3ihub.model.Dog;
import com.c3ihub.service.DserviceInterface;

@CrossOrigin(origins = "*")
@RestController
public class Dcontroller {

	@Autowired
	private DserviceInterface dserviceInterace;
	
	@PostMapping("/dogs")
	public ResponseEntity<Dog> addDog(@RequestBody Dog dog){
		return new ResponseEntity<Dog>(dserviceInterace.addDog(dog),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/dogs")
	public ResponseEntity<String> getDog(@RequestParam String dogName){
		return new ResponseEntity<String>(dserviceInterace.getDog(dogName),HttpStatus.OK);
		
	}

	
	@GetMapping("/allDogs")
	public ResponseEntity<List<Dog>> getAllDog(){
		return new ResponseEntity<List<Dog>>(dserviceInterace.getAllDog(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteAllDogs")
	public ResponseEntity<String> deleteAll(){
		return new ResponseEntity<String>(dserviceInterace.deleteAll(),HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteDogs/{dog_uniqueid}")
	public ResponseEntity<String> delete(@PathVariable Integer dog_uniqueid) {
	    String result = dserviceInterace.delete(dog_uniqueid);
	    HttpStatus status = result.equals("Successfully deleted") ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

	    return new ResponseEntity<>(result, status);
	}
	@PatchMapping("/updatesDogDetails/{dog_uniqueid}")
	public ResponseEntity<Dog> update(@PathVariable Integer dog_uniqueid, @RequestBody Dog dogUpdateRequest) {
	    return new ResponseEntity<>(dserviceInterace.update(dog_uniqueid, dogUpdateRequest.getName(), dogUpdateRequest.getNature(), dogUpdateRequest.getBreed()), HttpStatus.OK);
	}

	
}
