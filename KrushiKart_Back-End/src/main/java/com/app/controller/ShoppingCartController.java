package com.app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_Exceptions.ShoppingCartException;
import com.app.dto.AddProductDto;
import com.app.dto.CartDto;
import com.app.dto.CartItemDto;
import com.app.dto.RemoveCartItemsDto;
import com.app.dto.ResponseDto;
import com.app.pojos.CartItem;
import com.app.pojos.Categorys;
import com.app.pojos.Products;
import com.app.service.ShoppingCart.IShoppingCartServices;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cart")
@Slf4j
public class ShoppingCartController {
	//dependency injection
	@Autowired
	private IShoppingCartServices shoppingCartService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<?> addToCart(@RequestBody AddProductDto cartDto ) throws ShoppingCartException{
		shoppingCartService.addProduct(cartDto.getProductId(), cartDto.getQuantity(), cartDto.getCustomerId());
		return new ResponseEntity<>("Added sucessfully", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCartItemsList(@PathVariable("id") Long id) {
		//log.info("In Shopping Cart controller : Get cart item list");
		List<CartItem> cartitems = shoppingCartService.listCartItems(id);
		return new ResponseEntity<>(cartitems, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<?> removeItemsFromCart(@RequestBody RemoveCartItemsDto prodDetails) {
//		log.info("In Shopping Cart controller : removeItemsFromCart");
		shoppingCartService.removeProduct(prodDetails.getProductId(), prodDetails.getCustomerId());
		return new ResponseEntity<>("item removed", HttpStatus.OK);

	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> emptyCart(@PathVariable Long id) {
		
		shoppingCartService.deleteByUser(id);
		return new ResponseEntity<>("item deleted ", HttpStatus.OK);
	}
	
	@GetMapping("/total/{id}")
	public ResponseEntity<?> getTotalCartAmount(@PathVariable Long id) {
		double Total_amount = shoppingCartService.getTotalAmount(id);
		return new ResponseEntity<>(Total_amount, HttpStatus.OK);
	}
	

}
