package com.vhkkl.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderResponseDto {

	private Long orderId;
	private Long userId;
	private BigDecimal totalPrice;
	private String status;
	private List<OrderItemResponseDto> orderItemResponse;
	
}
