package com.vhkkl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer credentialId;
	
	@Column(unique=true) // make usernmae unique
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING) // by default value of this will store as 0  or 1 unless we specity this annotation
	@Column(name="role")
	private RoleBasedAuthority roleBasedAuthority; //imp for JWT security
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id" ,unique=true)
	@JsonIgnore // Tells Jakson don't include this field in JSON output
 	private User user; // foreign key in this table 
}
