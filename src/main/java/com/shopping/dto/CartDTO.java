package com.shopping.dto;

public class CartDTO {
	private ProductDTO product;
	private int quantity;

	public CartDTO() {
		super();
		
	}
	
	public CartDTO(ProductDTO product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}



	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
