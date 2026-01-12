package com.vhkkl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vhkkl.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	
}
