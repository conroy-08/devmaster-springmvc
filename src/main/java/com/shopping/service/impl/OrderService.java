package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.converter.OrderConverter;
import com.shopping.dto.CartDTO;
import com.shopping.dto.CartInfoDTO;
import com.shopping.dto.CustomerDTO;
import com.shopping.dto.OrderDTO;
import com.shopping.entity.OrderDetailsEntity;
import com.shopping.entity.OrderEntity;
import com.shopping.entity.ProductEntity;
import com.shopping.repository.OrderDetailsRepository;
import com.shopping.repository.OrderRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired 
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Override
	public void saveOrder(CartInfoDTO cartInfo) {
		OrderEntity order = new OrderEntity();
		order.setAmount(cartInfo.getAmountTotal());
		
		CustomerDTO customer = cartInfo.getCustomer();
		order.setCustomerName(customer.getCustomerName());
		order.setCustomerAddress(customer.getCustomerAddress());
		order.setCustomerEmail(customer.getCustomerAddress());
		order.setCustomerPhone(customer.getCustomerPhone());
		order.setOrderDate(new Date());
		orderRepository.save(order);
		
		
		List<CartDTO> listCart = cartInfo.getCartDTO();
		for (CartDTO cartDTO : listCart) {
			OrderDetailsEntity orderDetails = new OrderDetailsEntity();
			orderDetails.setOrder(order);
			orderDetails.setAmount(cartDTO.getQuantity()*cartDTO.getProduct().getPrice());
			orderDetails.setPrice(cartDTO.getProduct().getPrice());
			orderDetails.setQuanity(cartDTO.getQuantity());
			ProductEntity product = productRepository.findOne(cartDTO.getProduct().getId());
			orderDetails.setProduct(product);	
			orderDetailsRepository.save(orderDetails);
		}
	}

	@Override
	public List<OrderDTO> getAll() {
		List<OrderDTO> order = new ArrayList<>();
		List<OrderEntity> entities = orderRepository.findAll();
		for (OrderEntity item : entities) {
			OrderDTO dto = orderConverter.convertDTO(item);
			order.add(dto);
		}
		return order;
	}

}
