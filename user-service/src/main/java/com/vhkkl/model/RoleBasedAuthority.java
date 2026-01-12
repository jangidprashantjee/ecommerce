package com.vhkkl.model;

public enum RoleBasedAuthority {

	ROLE_ADMIN("ADMIN"),
	ROLE_USER("USER");

	private final String role;
	RoleBasedAuthority(String role) {
		this.role=role;
	}
	public String getRole() {
		return role;
	}
	
}
