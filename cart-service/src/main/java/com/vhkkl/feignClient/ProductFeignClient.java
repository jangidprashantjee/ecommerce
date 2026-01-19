package com.vhkkl.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service",url = "${product.service.url}",path="/api/product")
public interface ProductFeignClient {
	
	@GetMapping("/exists/{productId}")
	public Boolean isProductExists(@PathVariable Long productId);

}
