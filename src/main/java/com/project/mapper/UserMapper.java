package com.project.mapper;

import com.project.dto.UserDto;
import com.project.pojos.User;

public class UserMapper
{
	private UserMapper() throws IllegalAccessException
	{
		throw new IllegalAccessException();
	}
	
	//static method to convert Dto to entity
	public static User mapToUser(UserDto userDto)
	{
		User user = new User();
		user.setFirstName(userDto.getFirstName());	
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setLocation(userDto.getLocation());
		user.setDesignation(userDto.getDesignation());
		user.setIntroduction(userDto.getIntroduction());
		user.setSkills(userDto.getSkills());
		user.setRate(userDto.getRate());
		
		return user;
	
	}
	
	//static method to convert entity to Dto
	public static UserDto mapToUserDto(User user)
	{
		UserDto userDto = new UserDto();
		
		userDto.setFirstName(user.getFirstName());	
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setLocation(user.getLocation());
		userDto.setDesignation(user.getDesignation());
		userDto.setIntroduction(user.getIntroduction());
		userDto.setSkills(user.getSkills());
		userDto.setRate(user.getRate());
		
		return userDto;
	}
	
}
