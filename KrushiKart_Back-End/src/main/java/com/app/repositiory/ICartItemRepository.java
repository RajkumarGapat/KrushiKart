package com.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.dto.CartDto;
import com.app.pojos.CartItem;
import com.app.pojos.Products;
import com.app.pojos.User;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Long>{

	List<CartItem> findByCurrentUser(User customer);

	@Modifying
	@Query("DELETE FROM CartItem c WHERE c.currentUser.id = ?1 AND c.products.id = ?2")
	void deleteByCurrentUserAndProducts(Long id, Long id2);

	

	
	
	



	

	



	

}
