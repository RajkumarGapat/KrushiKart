/*package com.app.cartTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.CartItem;
import com.app.pojos.Products;
import com.app.pojos.User;
import com.app.repositiory.CartItemRepositiory;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ShoppingCartTest {
	
	@Autowired
	private CartItemRepositiory cartRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAddOneCartItem() {
		Products product =entityManager.find(Products.class,3);
		User customer=entityManager.find(User.class,2);
		
		CartItem newItem=new CartItem();
		newItem.setCurrentUser(customer);
		newItem.setProducts(product);
		newItem.setQuantity(1);
		newItem.setCreatedOn(LocalDate.now());
		 CartItem savedCartItem=cartRepo.save(newItem);
		 
		 assertTrue(savedCartItem.getId()>0);
	}
	
	@Test
	public void testgetCartItemsbyCustomer() {
		User user=new User();
		user.setId((long) 1);
		List<CartItem> cartItem=cartRepo.findByCurrentUser(user);
		assertEquals(1,cartItem.size());
	}

}*/
