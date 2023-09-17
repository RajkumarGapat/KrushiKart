package com.app.dto;

import com.app.pojos.Products;

public class CartItemDto {
	
	private Long id;
	private Integer quantity;
	private Products product;
	
	public CartItemDto(Long id, Integer quantity, Products product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}

	public CartItemDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	
	

}
