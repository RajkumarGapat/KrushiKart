package com.app.service.ShoppingCart;

import java.util.List;

import com.app.custom_Exceptions.ShoppingCartException;
import com.app.dto.CartDto;
import com.app.pojos.CartItem;
import com.app.pojos.Products;
import com.app.pojos.User;

public interface IShoppingCartServices {

	void addProduct(Long productId, Integer quantity, Long customerId) throws ShoppingCartException;
	
// anothe method to get cart ithems
//	List<CartItem> listOfCartitems(User user);

	List<CartItem> listCartItems(Long id);

	void deleteByUser(Long id);

	void removeProduct(Long productId, Long customerId);

	double getTotalAmount(Long id);

	



}
