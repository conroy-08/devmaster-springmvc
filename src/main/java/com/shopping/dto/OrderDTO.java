package com.shopping.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO extends AbstractDTO<OrderDTO> {
	private double amount;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerPhone;
	private List<OrderDetailsDTO> details;
    private Date orderDate;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public List<OrderDetailsDTO> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetailsDTO> details) {
		this.details = details;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	

}
