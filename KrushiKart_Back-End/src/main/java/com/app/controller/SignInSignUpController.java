
package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Jwt_utils.JwtUtils;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.DeliveryBoyDto;
import com.app.dto.SellerDto;
import com.app.dto.Userdto;
import com.app.pojos.Address;
import com.app.service.DeliveryBoy.IDeliveryBoyService;
import com.app.service.Supplier.ISupplierService;
import com.app.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class SignInSignUpController {
	
	//user services dependency injected
	@Autowired
	private IUserService userServices;
	
	@Autowired
	private ISupplierService sellerServices;
	
	@Autowired
	private IDeliveryBoyService deliveryBoyServices;
	
	@Autowired
	private JwtUtils utils;
	// dep : Auth mgr
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping("/user/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid Userdto userObj,BindingResult bindingRelt){
		
		// invoke service layer method
		
		 return ResponseEntity.status(HttpStatus.CREATED).body(userServices.saveNewUser(userObj));
		
	}
	
	@PostMapping("/seller/signup")
	public ResponseEntity<?> sellerRegistration(@RequestBody @Valid SellerDto sellerobj,BindingResult br){
		if(br.hasErrors()) {
			return  ResponseEntity.badRequest().body(br.getAllErrors());// :
		}
		// invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(sellerServices.saveSupplier(sellerobj));
	}
	
	@PostMapping("/deliveryboy/signup")
	public ResponseEntity<?> deliveryBoyRegistration(@RequestBody @Valid DeliveryBoyDto deliveryBoy) {
		System.out.println("in reg deliveryBoy : deliveryBoy " + deliveryBoy + " roles " + deliveryBoy.getUserRole());// {....."roles"
																													// :
		// invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(deliveryBoyServices.saveDeliveryBoy(deliveryBoy));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid AuthRequest request,BindingResult br) {
		// store incoming user details(not yet validated) into Authentication object
		// Authentication i/f ---> imple by UserNamePasswordAuthToken
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
//		log.info("auth token " + authToken);
		try {
			// authenticate the credentials
			Authentication authenticatedDetails = manager.authenticate(authToken);
			Userdto user = userServices.getUserByEmail(authenticatedDetails.getName());

			// => auth succcess
			return ResponseEntity
					.ok(new AuthResp("Auth successful!", utils.generateJwtToken(authenticatedDetails), user));
		} catch (BadCredentialsException e) { // lab work : replace this by a method in global exc handler
			// send back err resp code
			System.out.println("err " + e); 
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

	}

}
