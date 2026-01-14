package com.vhkkl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vhkkl.dto.CartRequestDto;
import com.vhkkl.dto.CartResponseDto;
import com.vhkkl.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/cart")
@Slf4j
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping
	public CartResponseDto addToCart(@RequestBody CartRequestDto cartRequestDto)
	{
		// if added same product to cart then quantity should increase
		log.info("cart item add to cart");
		return cartService.addToCart(cartRequestDto);
	}
	
	@GetMapping("/{userId}")
	public List<CartResponseDto> getCartByUserId(@PathVariable Long userId)
	{
		log.info("getCart by userid");
		return cartService.getUserCart(userId);
	}
	
	@PutMapping("/update")
	public CartResponseDto updateQuantity(@RequestBody CartRequestDto cartRequestDto)
	{
		return cartService.updateQuantity(cartRequestDto);
	}
	//users/{userId}/cart/{productId} take as both pathvariable , generally userId is not passed 
	@DeleteMapping("/remove/{productId}")
	public void removeItemFromCart(@PathVariable Long productId, @RequestParam Long userId)
	{
		cartService.removeItemFromUserCart(userId, productId);
	}
	
	@DeleteMapping("/clear/{userId}")
	public void clearCart(@PathVariable Long userId)
	{
		cartService.clearCart(userId);
	}
}
