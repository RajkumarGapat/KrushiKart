package com.app.custom_Exceptions;

@SuppressWarnings("serial")
public class OrderNotFoundException extends Exception {

	public OrderNotFoundException(String message) {
		super(message);
	}

}
