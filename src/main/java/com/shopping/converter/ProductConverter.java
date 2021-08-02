package com.shopping.converter;

import org.springframework.stereotype.Component;

import com.shopping.dto.ProductDTO;
import com.shopping.entity.ProductEntity;

@Component
public class ProductConverter {
	public  ProductDTO convertDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		dto.setPrice(entity.getPrice());
		return dto;
    }
	
	public ProductEntity convertEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setName(dto.getName());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		entity.setPrice(dto.getPrice());
		return entity;
	}
	public ProductEntity convertEntity(ProductEntity entity ,ProductDTO dto) {
		entity.setName(dto.getName());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		entity.setPrice(dto.getPrice());
		return entity;
	}
}
