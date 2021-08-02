package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.converter.ProductConverter;
import com.shopping.dto.ProductDTO;
import com.shopping.entity.ProductEntity;
import com.shopping.repository.ProductRepository;
import com.shopping.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public List<ProductDTO> getAll() {
		List<ProductDTO> pro = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.convertDTO(item);
			pro.add(dto);
		}
		return pro;
	}

	@Override
	public ProductDTO createOrUpdate(ProductDTO product) {
		ProductEntity productEntity = new ProductEntity();
		if(product.getId() != null) {
			ProductEntity oldPro = productRepository.findOne(product.getId());
			productEntity = productConverter.convertEntity(oldPro, product);	
		}else {
			productEntity = productConverter.convertEntity(product);
		}
		return productConverter.convertDTO(productRepository.save(productEntity));
		
	}

	@Override
	public ProductDTO findOneById(Long id) {	
		return productConverter.convertDTO(productRepository.findOne(id)); 
	}

	@Override
	public void deleteProduct(Long id) {
	  productRepository.delete(id);	
	}

}
