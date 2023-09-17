package com.app.custom_Exceptions;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class UserHandlingException extends RuntimeException {
	public UserHandlingException(String mesg) {
		super(mesg);
	}

	public UserHandlingException(String string, HttpStatus forbidden) {
		// TODO Auto-generated constructor stub
	}
}
