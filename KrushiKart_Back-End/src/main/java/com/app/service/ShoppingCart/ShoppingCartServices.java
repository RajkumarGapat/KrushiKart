package com.app.service.ShoppingCart;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_Exceptions.ProductNotExistsExceptions;
import com.app.custom_Exceptions.ShoppingCartException;
import com.app.custom_Exceptions.UserHandlingException;
import com.app.dto.AddProductDto;
import com.app.dto.CartDto;
import com.app.pojos.CartItem;
import com.app.pojos.Products;
import com.app.pojos.User;
import com.app.repositiory.CartItemRepositiory;
import com.app.repositiory.ICartItemRepository;
import com.app.repositiory.ProductRepository;
import com.app.repositiory.UserRepositiory;
import com.app.service.ProdServiceInterface;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ShoppingCartServices implements IShoppingCartServices {
	
	@Autowired
	private UserRepositiory userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private ProdServiceInterface prodService;
	
	@Autowired
	private ICartItemRepository cartRepo;
	
	@Autowired CartItemRepositiory cartItemRepo;

	@Override
	public void addProduct(Long productId, Integer quantity, Long customerId) throws ShoppingCartException {
		Integer updatedQuantity = quantity;
		Optional<User> user = userRepo.findById(customerId);
		User customer = new User();
		if (user != null) {
			customer = mapper.map(user, User.class);
		} else {
			throw new UserHandlingException("NO cart details are found for given customer id");
		}
		try {
			Products product=prodService.findById(productId);
			CartItem cartItem=new CartItem();
			if(cartItem != null) {
				updatedQuantity = cartItem.getQuantity() + quantity;
				if (updatedQuantity < 0) {
					throw new UserHandlingException("Invalid quanity");
				}
				if (updatedQuantity > 5) {
					throw new ShoppingCartException("Could not add more " + quantity + " item(s)"
							+ " because there's already " + cartItem.getQuantity() + " item(s) "
							+ "in your shopping cart. Maximum allowed quantity is 5.");
				}else {
			
			cartItem.setProducts(product);
			cartItem.setCurrentUser(customer);
			cartItem.setQuantity(updatedQuantity);
			cartItem.setCreatedOn(null);
			cartRepo.save(cartItem);
				}
			}
			
		} catch (ProductNotExistsExceptions e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CartItem> listCartItems(Long custId) {
		Optional<User> OpCustomer = userRepo.findById(custId);
		if (OpCustomer != null) {
			User customer = mapper.map(OpCustomer, User.class);
			return cartItemRepo.findByCurrentUser(customer);
		} else
			throw new UserHandlingException("Invalid customer details");
	}

	@Override
	public void deleteByUser(Long CustId) {
		Optional<User> OpCustomer = userRepo.findById(CustId);
		if (OpCustomer != null) {
			User customer = mapper.map(OpCustomer, User.class);
			cartItemRepo.deleteByCurrentUser(customer.getId());
		} else
			throw new UserHandlingException("No cart details for given cutsomer id " + CustId);
		
	}

	@Override
	public void removeProduct(Long productId, Long customerId) {
		Optional<User> OptionalCustomer = userRepo.findById(customerId);
		User customer = new User();
		if (OptionalCustomer != null) {
			customer = mapper.map(OptionalCustomer, User.class);
		} else {
			throw new UserHandlingException("Invalid Customer Details");
		}
		cartItemRepo.deleteByCurrentUserAndProducts(customer.getId(), productId);
	}

	@Override
	public double getTotalAmount(Long custId) {
		double totalCartAmount = 0.00;
		List<CartItem> cartItems = listCartItems(custId);
		for (CartItem cartItem : cartItems) {
			totalCartAmount = totalCartAmount + cartItem.getTotalOfProduct();
		}
		return totalCartAmount;
	}

	//add method to get all product by customer id
//	public List<CartItem> listOfCartitems(User user){
//		return cartItemRepo.findByCurrentUser(user);
//	}
	
	
	

	
	

}
