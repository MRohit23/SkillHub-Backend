package com.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.exceptions.UserNotFoundException;
import com.project.dao.UserDao;
import com.project.dto.UserDto;
import com.project.mapper.UserMapper;
import com.project.pojos.User;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDao userDao;
	

	@Override
	public String addUserDetails(UserDto userDto) 
	{
		User user = UserMapper.mapToUser(userDto); 
		// TODO: add encrypted password
		userDao.save(user);
		return "User Register Successfully";
	}

	@Override
	public UserDto getUserDetailsById(Long id) 
	{
		User user = userDao.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Invalid user id"));
		
		return UserMapper.mapToUserDto(user);
	}
	
	@Override
	public List<UserDto> getAllUserDetails() 
	{
		 List<User> users = userDao.findAll();
		 
		 return users.stream()
		 	.map(user -> UserMapper.mapToUserDto(user))
		 	.collect(Collectors.toList());
	
	}
	


	@Override
	public UserDto updateUserDetails(Long id, UserDto userDto) 
	{
		if(userDao.existsById(id))
		{
			System.out.println("updated successfully");
			
			User user = UserMapper.mapToUser(userDto);
			user.setId(id);
			
			user = userDao.save(user);
			user.setPassword("");
			
			return UserMapper.mapToUserDto(user);
			
		} else {
			throw new UserNotFoundException("Update failed. User details not found");
		}
		
		
	}

	
	
	
	@Override
	public String deleteUserDetails(Long id) 
	{
		if(userDao.existsById(id))
		{
			System.out.println("deleted succesfully");
			userDao.deleteById(id);
			return "delete succesfully";
		}
		else
		{
			return"id not found";
		}
		
	}

}
