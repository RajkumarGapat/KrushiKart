package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
public class RemoveCartItemsDto {

	private Long productId;

	private Long customerId;

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

	@Override
	public String toString() {
		return "RemoveCartItemsDto [productId=" + productId + ", customerId=" + customerId + "]";
	}
	
	
}
