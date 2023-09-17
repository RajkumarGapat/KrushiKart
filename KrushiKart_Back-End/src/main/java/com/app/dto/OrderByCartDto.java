package com.app.dto;

import com.app.pojos.Address;
import com.app.pojos.PaymentType;
import com.app.pojos.User;

import lombok.Getter;
import lombok.Setter;


public class OrderByCartDto {
	private Long id;
	private Address address;
	private PaymentType paymentType;
	
	public OrderByCartDto(Long id, Address address, PaymentType paymentType) {
		super();
		this.id = id;
		this.address = address;
		this.paymentType = paymentType;
	}

	public OrderByCartDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	
}
