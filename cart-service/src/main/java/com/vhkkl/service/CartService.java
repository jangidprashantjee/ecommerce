package com.vhkkl.service;

import java.util.List;

import com.vhkkl.dto.CartRequestDto;
import com.vhkkl.dto.CartResponseDto;

public interface CartService {

	CartResponseDto addToCart(CartRequestDto cartRequestDto);
	List<CartResponseDto> getUserCart(Long userId);
	void removeItemFromUserCart(Long userId,Long productId);
	CartResponseDto updateQuantity(CartRequestDto cartRequestDto);
	void clearCart(Long UserId);
}
