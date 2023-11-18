package com.c3ihub.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	
	private String name;
	

	private String userRole;
	
	@NotBlank(message = "address should not be blank")
	private String address;
	

	@Email(message = "email should be in proper format")
	private String email;
	
	@NotBlank(message = "password should not be blank")
	private String password;
	
	@NotBlank(message = "MobNumber should not be blank")
	private String mobNumber;
	
	
	private String userPosition;
	@JsonIgnore
	@OneToMany
	private List<Dog> list1=new ArrayList<>();
	


}
