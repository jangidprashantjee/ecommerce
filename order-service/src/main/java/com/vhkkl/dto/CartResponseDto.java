package com.vhkkl.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartResponseDto {
	private Long id;
	private Long userId;
	private Long productId;
	private Integer quantity;
}
