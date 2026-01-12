package com.vhkkl.mappers;

import org.mapstruct.Mapper;

import com.vhkkl.dto.CredentialDto;
import com.vhkkl.model.Credential;

@Mapper(componentModel="spring")
public interface CredentialMapper {

	
	CredentialDto toDto(Credential credential);
}
