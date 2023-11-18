package com.c3ihub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String name;
	private String email;
    private String password;
    private String userRole;
    private String address;
    private String mobNumber;
}
