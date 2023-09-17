package com.app.pojos;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity

public class OTP {

	@Id
	@Column(length = 50)
	private String email;

	private int otp;

	private LocalTime timeStamp;

	public OTP(String email, int otp) {
		super();
		this.email = email;
		this.otp = otp;
		this.timeStamp = LocalTime.now();
	}

	public OTP() {
		super();
		this.timeStamp = LocalTime.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public LocalTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
