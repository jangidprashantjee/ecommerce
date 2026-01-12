package com.vhkkl.dto;

import com.vhkkl.model.RoleBasedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CredentialDto {

	
	private String username;
	private String password;
	
	private RoleBasedAuthority roleBasedAuthority;
}
