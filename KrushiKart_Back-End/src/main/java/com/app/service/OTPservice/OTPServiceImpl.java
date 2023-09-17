package com.app.service.OTPservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_Exceptions.UserHandlingException;
import com.app.pojos.OTP;
import com.app.repositiory.OTPRepositary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OTPServiceImpl implements OTPService {

	@Autowired
	private OTPRepositary otpRepo;

	@Override
	public boolean setOTP(OTP otp) {
//		log.info("set otp");
		otpRepo.save(otp);
		return true;
	}

	@Override
	public OTP getOTP(String email) {
//		log.info("get otp");
		OTP findById = otpRepo.findById(email).orElseThrow(() -> new UserHandlingException("User not found"));
		return findById;
	}

	@Override
	public boolean deleteById(String email) {
		
		otpRepo.deleteById(email);
		
		return true;
	}

}
