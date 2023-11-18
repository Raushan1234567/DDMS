package com.c3ihub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dog_uniqueid;
	
	@NotBlank(message = "Name must be required")
	private String name;
	
	@NotBlank(message = "Nuture must be required")
	private String nature;
	
	@NotBlank(message = "Breed must be needed")
	private String breed;
	
	
	
}
