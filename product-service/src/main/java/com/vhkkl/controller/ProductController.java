package com.vhkkl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vhkkl.dto.ProductRequestDto;
import com.vhkkl.dto.ProductResponseDto;
import com.vhkkl.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto)
	{
		log.info("addproduct");
		return productService.addProduct(productRequestDto);
		
	}
	
	@GetMapping("/exists/{productId}")
	public Boolean isProductExists(@PathVariable Long productId)
	{
		log.info("does product exists");
		return productService.isProductExists(productId);
	}
	
	
	@GetMapping("/getproduct/{productId}")
	public ProductResponseDto getProductById(@PathVariable Long productId)
	{
		log.info("get product by id");
		return productService.getProductById(productId) ;
	}
	
}
