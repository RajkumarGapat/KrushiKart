package com.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.*;

public interface IPaymentRepositary extends JpaRepository<Payment, Long> {

	//Get payment by order ID
	
}
