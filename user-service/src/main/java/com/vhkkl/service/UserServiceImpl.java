package com.vhkkl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhkkl.dto.UserDto;
import com.vhkkl.mappers.UserMapper;
import com.vhkkl.model.Credential;
import com.vhkkl.model.User;
import com.vhkkl.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto save(UserDto userDto) {
		User user=userMapper.toEntity(userDto);
		
		Credential credential=user.getCredential();
		
		credential.setUser(user);
		
		User dbUser=userRepository.save(user);
		return userMapper.toDto(dbUser);
	}
	
	@Override
	public UserDto findById(Integer userId) {
          return userRepository.findById(userId).map(userMapper::toDto) 
        		  .orElseThrow(()->new RuntimeException("User does not exists")); // java 8 method of exception handling
	}

	@Override
	public UserDto update(Integer userId, UserDto userDto) {
		return null;
	}

}
