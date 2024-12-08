package com.project.service;

import java.util.List;

import com.project.dto.UserDto;

public interface UserService 
{
	//add a method to insert user details
	String addUserDetails(UserDto user);
	
	UserDto getUserDetailsById(Long id);
	
	//add a method to get User details
	List<UserDto> getAllUserDetails();
	
	//add a method to update User Details
	UserDto updateUserDetails(Long id, UserDto userDeto);
	
	//add a method to delete user details
	String deleteUserDetails(Long id);

}
