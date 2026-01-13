package com.vhkkl.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

	private String name;
	private String description;
	private BigDecimal price;
	private Integer stock;
}
