package com.shopping.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.ProductDTO;
import com.shopping.service.IProductService;

@RestController(value = "productApiOfAdmin")
public class ProductApi {
	@Autowired
	private IProductService productService;

	@PostMapping("/api/product")
	public ProductDTO saveProduct(@RequestBody ProductDTO dto) {
		return productService.createOrUpdate(dto);

	}

	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO updateProduct) {
		return productService.createOrUpdate(updateProduct);

	}
	
	
}
