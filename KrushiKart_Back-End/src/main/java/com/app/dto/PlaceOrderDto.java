package com.app.dto;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class PlaceOrderDto {

	private Long supplierId;
	
	@JsonIgnore
	private Products product;

	private String notes;

	private int quantity;

	public PlaceOrderDto(Long supplierId, Products product, String notes, int quantity) {
		super();
		this.supplierId = supplierId;
		this.product = product;
		this.notes = notes;
		this.quantity = quantity;
	}

	public PlaceOrderDto() {
		super();
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PlaceOrderDto [supplierId=" + supplierId + ", product=" + product + ", notes=" + notes + ", quantity="
				+ quantity + "]";
	}
	
	
}
