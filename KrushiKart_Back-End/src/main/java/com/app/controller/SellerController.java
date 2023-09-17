package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SellerDto;
import com.app.service.Supplier.ISupplierService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/seller")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class SellerController {
	
	@Autowired
	private ISupplierService sellerServices;
	
	@PostMapping("/register")
	public ResponseEntity<?> addNewSeller(@RequestBody SellerDto sellerdtoObj){
//		log.info("In Supplier controller : addSupplier");
		return new ResponseEntity<>(sellerServices.saveSupplier(sellerdtoObj), HttpStatus.OK);
	}

}
