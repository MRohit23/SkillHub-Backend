package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.UserDto;
import com.project.service.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	public UserController()
	{
		System.out.println("in user controller");
	}
	
	
	@PostMapping
	ResponseEntity<String> addUserDetails(@Valid @RequestBody UserDto userDto)
	{
		System.out.println("user details added successfully");
		String msg = userService.addUserDetails(userDto);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(msg);
	}
	
	//http://localhost:8080/users?id=123
	@GetMapping("/{id}")
	ResponseEntity<?> getUserDetailsById(@PathVariable Long id)
	{
		System.out.println("fetch all data of users");
		UserDto userDto = userService.getUserDetailsById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(userDto);
	}
	
	@GetMapping
	ResponseEntity<List<UserDto>> getAllUserDetails()
	{
		System.out.println("fetch all data of users");
		List<UserDto> users = userService.getAllUserDetails();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(users);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<?> updateUserDetails(@PathVariable Long id, @RequestBody UserDto userDto)
	{
		System.out.println("updated user details");
		try {
			return ResponseEntity.ok(userService.updateUserDetails(id, userDto));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteUserDetails(@PathVariable Long id)
	{
		System.out.println("deleted Successfully" + id);
		try {
			return ResponseEntity.ok(userService.deleteUserDetails(id));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		
	}
	
	
	
	
	
}
