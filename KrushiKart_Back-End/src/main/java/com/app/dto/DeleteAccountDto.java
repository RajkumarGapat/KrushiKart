package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class DeleteAccountDto {

	private String email;

	private String oldPassword;

	public DeleteAccountDto(String email, String oldPassword) {
		super();
		this.email = email;
		this.oldPassword = oldPassword;
	}

	public DeleteAccountDto() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@Override
	public String toString() {
		return "DeleteAccountDto [email=" + email + ", oldPassword=" + oldPassword + "]";
	}

	

	
	
}
