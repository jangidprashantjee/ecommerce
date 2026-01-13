package com.vhkkl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhkkl.dto.CredentialDto;
import com.vhkkl.mappers.CredentialMapper;
import com.vhkkl.repository.CredentialRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CredentialService {

   @Autowired
   private CredentialRepository credentialRepository;
   
   
   @Autowired
   private CredentialMapper credentialMapper;
   
   public CredentialDto findByusername(String username)
   {
	    return credentialRepository.findByUsername(username)
	    		.map(credentialMapper::toDto)
	    		.orElseThrow(()-> new RuntimeException("Username not found"));   
   }
}
