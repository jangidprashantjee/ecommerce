package com.vhkkl.service;

import com.vhkkl.dto.UserDto;


public interface UserService {
     UserDto findById(UserDto userDto);
     UserDto save(UserDto userDto);
     UserDto update(Integer userId,UserDto user);
}
