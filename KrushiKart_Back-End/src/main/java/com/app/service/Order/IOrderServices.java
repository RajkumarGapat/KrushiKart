package com.app.service.Order;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Orders;
import com.app.pojos.PaymentType;
import com.razorpay.RazorpayException;

public interface IOrderServices {

	Orders getOrders(Long id);


	String createOrderByUserCart(Long id, Address address, PaymentType paymentType) throws RazorpayException;

	List<Orders> getOrderList(Long Userid);

}
