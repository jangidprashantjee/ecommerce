package com.vhkkl.service;

import com.vhkkl.dto.UserDto;


public interface UserService {
     UserDto findById(Integer userId);
     UserDto save(UserDto userDto);
     UserDto update(Integer userId,UserDto user);
}
