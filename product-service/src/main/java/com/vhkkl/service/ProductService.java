package com.vhkkl.service;

import com.vhkkl.dto.ProductRequestDto;
import com.vhkkl.dto.ProductResponseDto;

public interface ProductService {

	ProductResponseDto addProduct(ProductRequestDto productRequestDto);
	
	Boolean isProductExists(Long productId);
	
	ProductResponseDto getProductById(Long productId);
}
