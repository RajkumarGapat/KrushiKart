package com.app.dto;

import java.util.List;



public class CartDto {
	private List<CartItemDto> cartItems;
	
	private double totalcost;

	public CartDto(List<CartItemDto> cartItems, double totalcost) {
		super();
		this.cartItems = cartItems;
		this.totalcost = totalcost;
	}

	public CartDto() {
		super();
	}

	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	

}
