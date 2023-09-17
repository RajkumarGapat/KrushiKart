package com.app.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
public class AddProductDto {
	
	private Long id;
	@NotNull
	private Long productId;
	@NotNull
	private Long customerId;
	private Integer quantity;
	
	public AddProductDto() {
		super();
	}

	
	public AddProductDto(Long id, Long productId, Long customerId, Integer quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
		this.quantity = quantity;
	}


	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
