package com.vhkkl.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vhkkl.dto.UserDto;

import jakarta.validation.Valid;

@FeignClient(name="user-service" ,url = "${user.service.url}",path="/users")
public interface UserFeignclient {

	@GetMapping("/{userId}")
	public UserDto fetchUser(@Valid @PathVariable Integer userId);
}
