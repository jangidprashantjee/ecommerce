package com.vhkkl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vhkkl.dto.UserDto;
import com.vhkkl.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	private Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) //201
	public UserDto createUser(@Valid @RequestBody UserDto userDto)
	{
		logger.info("Usercontroller :: createUser()",userDto.getEmailAddress());
		return userService.save(userDto);
	}
	
	@GetMapping("/{userId}")
	public UserDto fetchUser(@Valid @PathVariable Integer userId)
	{
		logger.info("Usercontroller :: fetchUser()",userId);
		return userService.findById(userId);
	}

	
	// PUT and DELETE User methods table
}
