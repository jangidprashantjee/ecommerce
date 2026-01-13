package com.vhkkl.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer stock;
}
