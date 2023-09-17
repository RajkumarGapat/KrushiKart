package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_Exceptions.OrderNotFoundException;
import com.app.dto.OrderByCartDto;
import com.app.pojos.Orders;
import com.app.service.Order.IOrderServices;
import com.razorpay.RazorpayException;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
	
	@Autowired
	private IOrderServices orderServices;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrder(@PathVariable("id") Long id) throws OrderNotFoundException {
//		log.info("In Order Controller : get Order");
		Orders order = orderServices.getOrders(id);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	@GetMapping("/userOrder/{userId}")

	public ResponseEntity<?> getOrderList(@PathVariable("userId") Long id) {
//		log.info("In Order Controller : get OrderList by user ID");
		List<Orders> orderList = orderServices.getOrderList(id);

		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}
	
	@PostMapping("/place")
	public ResponseEntity<?> placeOrderByCart(@RequestBody OrderByCartDto orderCart) throws RazorpayException {
//		log.info("In Order Controller : place OrderBycart");
		String order = orderServices.createOrderByUserCart(orderCart.getId(), orderCart.getAddress(),
				orderCart.getPaymentType());
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	
	

}
