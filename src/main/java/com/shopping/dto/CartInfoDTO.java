package com.shopping.dto;

import java.util.ArrayList;
import java.util.List;

public class CartInfoDTO {
	private CustomerDTO customer;
	List<CartDTO> CartDTO = new ArrayList<>();

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	
	
	public List<CartDTO> getCartDTO() {
		return CartDTO;
	}

	public void setCartDTO(List<CartDTO> cartDTO) {
		CartDTO = cartDTO;
	}

	public float getAmountTotal() {
		float total = 0;
		for (CartDTO cart : CartDTO) {
			total += cart.getQuantity()*cart.getProduct().getPrice();
		}
		return total;
	}

}
