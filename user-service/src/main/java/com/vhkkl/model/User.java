package com.vhkkl.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	
    // Eager vs Lazy loading , fetch type 
	//Lazy => don't load child/related data when main entity is loading ,load it only when we access
	//by default its eager, its like new query generated and performed from DB / slows down
	//Credential entity own the relationship and user field/variable in it holds the foreign key
    @OneToOne(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Credential credential;
}
