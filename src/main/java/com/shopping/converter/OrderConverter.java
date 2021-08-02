package com.shopping.converter;

import org.springframework.stereotype.Component;

import com.shopping.dto.OrderDTO;
import com.shopping.entity.OrderEntity;

@Component
public class OrderConverter {
	public  OrderDTO convertDTO(OrderEntity entity) {
		OrderDTO dto = new OrderDTO();
		dto.setCustomerName(entity.getCustomerName());
		dto.setCustomerAddress(entity.getCustomerAddress());
		dto.setCustomerPhone(entity.getCustomerPhone());
		dto.setCustomerEmail(entity.getCustomerEmail());
		dto.setOrderDate(entity.getOrderDate());
		return dto;
    }
	
	public OrderEntity convertEntity(OrderDTO dto) {
		OrderEntity entity = new OrderEntity();
		entity.setCustomerName(dto.getCustomerName());
		entity.setCustomerAddress(dto.getCustomerAddress());
		entity.setCustomerPhone(dto.getCustomerPhone());
		entity.setCustomerEmail(dto.getCustomerEmail());
		entity.setOrderDate(dto.getOrderDate());
		return entity;
	}
	
}
