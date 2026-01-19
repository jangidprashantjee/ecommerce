package com.vhkkl.service;

import com.vhkkl.dto.OrderResponseDto;
import com.vhkkl.dto.PlaceOrderRequestDto;

public interface OrderService {

	OrderResponseDto placeOrder(PlaceOrderRequestDto placeOrder);
}
