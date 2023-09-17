package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DeliveryBoyDto;
import com.app.dto.PlaceOrderDto;
import com.app.dto.SellerDto;
import com.app.dto.UpdatePriceDto;
import com.app.dto.Userdto;
import com.app.service.DeliveryBoy.IDeliveryBoyService;
import com.app.service.Supplier.ISupplierService;
import com.app.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class AdminController {
	
	@Autowired
	private IUserService userServices;
	
	@Autowired
	private ISupplierService sellerServices;
	
	@Autowired
	private IDeliveryBoyService deliveryBoyService;
	
	// Add a method to get all customer list
	@GetMapping("/customers")
	public ResponseEntity<?> getCustomerList() {
		List<Userdto> listCustomer = userServices.getAllCustomer();
//		log.info("list :" + listCustomer.toString());
		return new ResponseEntity<>(listCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/sellers")
	public ResponseEntity<?> getSellerList(){
		List<SellerDto> sellerList=sellerServices.getAllSelles();
//		log.info("list :" + sellerList.toString());
		return new ResponseEntity<>(sellerList,HttpStatus.OK);
	}
	// Add a method to get all customer list
	@GetMapping("/deliveryboys")
	public ResponseEntity<?> getDeliveryBoysList() {
		List<DeliveryBoyDto> listDBoy = deliveryBoyService.getAllDeliveryBoy();
//		log.info("list :" + listDBoy.toString());
		return new ResponseEntity<>(listDBoy, HttpStatus.OK);
	}
	
	@PostMapping("/placeorder")
	public ResponseEntity<?> generateOrder(@RequestBody PlaceOrderDto placeOrder) {
		String msg = userServices.placeOrderToSeller(placeOrder);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/updateprice")
	public ResponseEntity<?> updatePrice(@RequestBody UpdatePriceDto updatePrice) {

		userServices.UpdateProdPrice(updatePrice);
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

}
