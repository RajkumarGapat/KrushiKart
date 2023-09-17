package com.app.controller;

import java.time.LocalTime;
import java.util.Random;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Jwt_utils.JwtUtils;
import com.app.dto.AuthResp;
import com.app.dto.DeleteAccountDto;
import com.app.dto.NewPasswordDto;
import com.app.dto.Userdto;
import com.app.pojos.OTP;
import com.app.pojos.User;
import com.app.repositiory.UserRepositiory;
import com.app.service.OTPservice.OTPService;
import com.app.service.emailServices.IEmailSendingService;
import com.app.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("/api/user")
@Slf4j
public class UserController {
	
	//dependency injection
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private IEmailSendingService emailService;
	
	@Autowired
	private OTPService otpService;

	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private UserRepositiory userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	Random random = new Random(1000);
	
	@PutMapping("/user/update")
	public ResponseEntity<?> updateExistingUser(@RequestBody Userdto userDTOObj){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateExistingUser(userDTOObj));
	}
	
	@DeleteMapping("/user/delete") 
	public String deleteUserDetails(@RequestBody DeleteAccountDto account) {
		
		return userService.deleteUserDetails(account);
	}
	
	
	@PermitAll
	@GetMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassord(@RequestParam("email") String email) {

//		log.info("In user controller forgot password" + email);
		int OTP1 = random.nextInt(9999) + LocalTime.now().getMinute() + LocalTime.now().getSecond();
//		log.info("OTP for" + OTP1 + " for email is :" + email);

		// check given email is exist in your data base or not
		Userdto userByEmail = userService.getUserByEmail(email);
		if (userByEmail != null) {
			OTP otp = new OTP();
			otp.setEmail(email);
			
			otp.setOtp(OTP1);
			// create subject and message for email
			String to = email;
			String subject = "OTP from KrushiKart";
			String msg = "<h1>Your OTP is:" + OTP1 + " ,DO NOT SHARE WITH ANY ONE</h1>";
			emailService.sendEmail(to, msg, subject); //click here for goto Email enter to Forgot password
			otpService.setOTP(otp);
			return ResponseEntity.ok("OTP sent to your email");
		} else {
			return new ResponseEntity<>("Invaild email", HttpStatus.NOT_FOUND);

		}

	}
	
	@PermitAll
	@GetMapping("/verify")
	public ResponseEntity<?> verifyOTP(@RequestParam int otp, @RequestParam String email) {
//		log.info("In verify OTP method");
		String sendEmail = email;
		System.out.println(otp + "   " + email);
		OTP otp2 = otpService.getOTP(email);
		// checking time boundation of 3 minutes
		LocalTime t2 = LocalTime.now();
		LocalTime t1 = otp2.getTimeStamp();
		LocalTime plusMinutes = t1.plusMinutes(3);
//		log.info(" " + plusMinutes);
		if ((otp == otp2.getOtp())) {
			if (t2.isBefore(plusMinutes)) {
				Userdto user = userService.getUserByEmail(sendEmail);
//				String token=utils.generateJwtToken(mapper.map(user, User.class));
				String token=utils.generateJwtToken(mapper.map(user, User.class));
				System.out.println(token+"========================");
				return ResponseEntity.ok(
                        new AuthResp("Auth successful!", utils.generateJwtToken(mapper.map(user, User.class)), user));
			} else {
				otpService.deleteById(sendEmail);
				return new ResponseEntity<>("OUT OF TIME", HttpStatus.FORBIDDEN);
			}

		} else {
			return new ResponseEntity<>("Wrong OTP", HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/newpassword")
	public String newPassword(@RequestBody @Valid NewPasswordDto newpassDto) {
		Userdto user = userService.getUserByEmail(newpassDto.getEmail());
		User newUser = mapper.map(user, User.class);
		newUser.setPassword(encoder.encode(newpassDto.getPassword()));
		userRepo.save(newUser);
		otpService.deleteById(newpassDto.getEmail());
		return "Password changed successfully....";

	}

}
