package com.project.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDto 
{
	//@NotEmpty(message = "Must Provide Valid First Name")
	//@Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters are allowed")
	private String firstName;
	
	//@NotEmpty(message = "Must Provide Valid Last Name")
	//@Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters are allowed")
	private String lastName;
	
	//@Email(message = "Must Provide Valid Email")
	private String email;
	
	//@NotEmpty(message = "Password should not be empty")
	//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Provide Valid Password Having "
	//		+ "Minimum size 8 Character Which Contains at Least 1 Uppercase 1 Lowercase and 1 Special Character")
	private String password;
	
	//@NotEmpty(message = "Provide Location")
   // @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters are allowed")
	private String location;
	
	//@NotEmpty(message = "Provide Designation")
	//@Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters are allowed")
	private String designation;
	
	//@NotEmpty(message = "Provide Small Introduction")
	private String introduction;
	
	//@NotEmpty(message = "Provide Skills")
	private String skills;
	
	//@NotNull(message = "Provide Rate in Number format")
	private long rate;
	
}
