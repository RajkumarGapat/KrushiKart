package com.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.PlaceOrder;

public interface IPlaceOrderRepository extends JpaRepository<PlaceOrder,Long>{

}
