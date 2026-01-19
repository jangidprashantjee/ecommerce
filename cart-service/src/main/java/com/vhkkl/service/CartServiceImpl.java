package com.vhkkl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhkkl.dto.CartRequestDto;
import com.vhkkl.dto.CartResponseDto;
import com.vhkkl.feignClient.ProductFeignClient;
import com.vhkkl.model.CartItem;
import com.vhkkl.repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductFeignClient productFeignClient;
	public CartResponseDto mapToCart(CartItem dbcartItem)
	{
		CartResponseDto cartResponseDto=new CartResponseDto();
		BeanUtils.copyProperties(dbcartItem, cartResponseDto);
		return cartResponseDto;
	}
	
	@Override
	public CartResponseDto addToCart(CartRequestDto cartRequestDto) {
		
		// TODO call product ms and validate  the  // also check the required quantity in stock 
		
		Boolean isExists=productFeignClient.isProductExists(cartRequestDto.getProductId());
		if(!isExists)
			throw new RuntimeException("Product doesn't exists");
		// TODO call user ms and validate user
		
		
		CartItem cart=new CartItem();
		BeanUtils.copyProperties(cartRequestDto, cart);
		
	    CartItem dbcart=cartRepository.save(cart);
		return mapToCart(dbcart);
	}

	@Override
	public List<CartResponseDto> getUserCart(Long userId) {
		// TODO 
		return cartRepository.findByUserId(userId).stream()
				.map(this::mapToCart)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void removeItemFromUserCart(Long userId, Long productId) {
		// TODO Auto-generated method stub
		cartRepository.deleteByUserIdAndProductId(userId, productId);
		
	}

	@Override
	public CartResponseDto updateQuantity(CartRequestDto cartRequestDto) {
		//Need userid and productid ,communication required
		CartItem dbcartItem=cartRepository.findByUserIdAndProductId(cartRequestDto.getUserId(), cartRequestDto.getProductId())
				.orElseThrow(()-> new RuntimeException("Item not in cart"));
		//Validate these many quantities are availble in productdatabas eor not
		dbcartItem.setQuantity(cartRequestDto.getQuantity());
		cartRepository.save(dbcartItem);
		return mapToCart(dbcartItem);
	}

	@Override
	@Transactional // default methods are transactional in nature ,but custom methods we have annotate it 
	public void clearCart(Long UserId) {
		// TODO Auto-generated method stub
		cartRepository.deleteByUserId(UserId);
	}
	
	

}
