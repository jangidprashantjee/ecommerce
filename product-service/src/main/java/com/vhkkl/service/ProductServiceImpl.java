package com.vhkkl.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhkkl.dto.ProductRequestDto;
import com.vhkkl.dto.ProductResponseDto;
import com.vhkkl.models.Product;
import com.vhkkl.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public ProductResponseDto addProduct(ProductRequestDto productRequestDto)
	{
		Product product=new Product();
		BeanUtils.copyProperties(productRequestDto, product);
		Product dbproduct=productRepository.save(product);
		return mapDto(dbproduct);
	}

	public ProductResponseDto mapDto(Product product)
	{
		ProductResponseDto productResponseDto=new ProductResponseDto();
		BeanUtils.copyProperties(product, productResponseDto);
		return productResponseDto;
	}
	@Override
	public Boolean isProductExists(Long productId) {
		// TODO Auto-generated method stub
		return productRepository.existsById(productId);
	}

	@Override
	public ProductResponseDto getProductById(Long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId).map( p->mapDto(p)).orElseThrow(()->new RuntimeException("No such product exists"));
	}
}
