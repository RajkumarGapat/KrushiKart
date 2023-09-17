package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
public class AuthResp {

	
	private String message;
	private String jwt;
	private Object user;
	
	public AuthResp(String message, String jwt, Object object) {
		super();
		this.message = message;
		this.jwt = jwt;
		this.user = object;
	}

	public AuthResp() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}
	


}
