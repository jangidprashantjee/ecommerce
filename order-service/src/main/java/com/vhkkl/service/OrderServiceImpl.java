package com.vhkkl.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhkkl.dto.CartResponseDto;
import com.vhkkl.dto.OrderResponseDto;
import com.vhkkl.dto.PlaceOrderRequestDto;
import com.vhkkl.dto.ProductResponseDto;
import com.vhkkl.dto.UserDto;
import com.vhkkl.exceptions.ResourceNotFoundException;
import com.vhkkl.feignclient.CartFeignClient;
import com.vhkkl.feignclient.ProductFeignClient;
import com.vhkkl.feignclient.UserFeignClient;
import com.vhkkl.repository.OrderRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductFeignClient productFeignClient;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private CartFeignClient cartFeignClient;
	
	@Override
	public OrderResponseDto placeOrder(PlaceOrderRequestDto placeOrder) {
		// validate the user
		UserDto userDto=validateUser(placeOrder.getUserId());
		if(userDto==null)throw new ResourceNotFoundException("User not found");
		
		List<CartResponseDto>fetchedOrderItems=fetchCartItems(placeOrder.getUserId());
		if(fetchedOrderItems.isEmpty() || fetchedOrderItems==null)
		{
			throw new ResourceNotFoundException("no items in cart");
		}
		
		
		calculateTotalPrice(fetchedOrderItems);
		return null;
	}
	
	public void calculateTotalPrice(List<CartResponseDto> cartItems)
	{
		BigDecimal total=BigDecimal.ZERO;
		for( CartResponseDto  item:cartItems)
		{
			ProductResponseDto product=productFeignClient.getProductById(item.getProductId());
			Integer=item.getQuantity();
			total+=(product.getPrice() * item.getQuantity());
		}
	}
	
	public UserDto validateUser(@Valid Long userId)
	{
		return userFeignClient.fetchUser(userId.intValue());
	}
	
	public List<CartResponseDto> fetchCartItems(@Valid Long userId)
	{
		return cartFeignClient.getCartByUserId(userId);
	}

}
