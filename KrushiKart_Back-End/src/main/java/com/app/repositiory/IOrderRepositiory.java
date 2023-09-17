package com.app.repositiory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Orders;
import com.app.pojos.User;

public interface IOrderRepositiory extends JpaRepository<Orders, Long>{

	Optional<Orders> findById(int id);

	List<Orders> findByUser(User map);

}
