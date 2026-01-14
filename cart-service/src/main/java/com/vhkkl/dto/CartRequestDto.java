package com.vhkkl.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartRequestDto {

	private Long userId;
	private Long productId;
	private Integer quantity;
}
