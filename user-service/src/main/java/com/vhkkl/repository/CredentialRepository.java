package com.vhkkl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vhkkl.model.Credential;

public interface CredentialRepository extends JpaRepository<Credential,Integer> {

	
	// method return type and input 
	
	Optional<Credential> findByUsername(String username);
	
	Optional<Credential> findByUsernameAndPassword(String username,String password);
}
