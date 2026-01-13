package com.vhkkl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vhkkl.dto.CredentialDto;
import com.vhkkl.service.CredentialService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/credential")
@Slf4j
public class CredentialController {

	@Autowired
	private CredentialService credentialService;
	
	@GetMapping("/username/{uname}")
	public CredentialDto findByusername( @PathVariable String uname)
	{ 
		log.info("credential info findByusername");
		return credentialService.findByusername(uname);
	}
}
