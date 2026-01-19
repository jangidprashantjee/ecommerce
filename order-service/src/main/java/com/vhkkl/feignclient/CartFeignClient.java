package com.vhkkl.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vhkkl.dto.CartResponseDto;

@FeignClient(name="cart-service" ,url = "${cart.service.url}",path="/api/cart")
public interface CartFeignClient {

	@GetMapping("/{userId}")
	public List<CartResponseDto> getCartByUserId(@PathVariable Long userId);
	
	@DeleteMapping("/clear/{userId}")
	public void clearCart(@PathVariable Long userId);
}
