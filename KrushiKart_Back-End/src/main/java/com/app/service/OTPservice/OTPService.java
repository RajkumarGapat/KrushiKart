package com.app.service.OTPservice;

import com.app.pojos.*;

public interface OTPService {

	// set Otp
	boolean setOTP(OTP otp);

	// getOtp
	OTP getOTP(String email);

	boolean deleteById(String email);
}
