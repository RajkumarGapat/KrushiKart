package com.app.service.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_Exceptions.UserHandlingException;
import com.app.dto.Userdto;
import com.app.pojos.Address;
import com.app.pojos.CartItem;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderStatus;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.PaymentStatus;
import com.app.pojos.PaymentType;
import com.app.pojos.Products;
import com.app.pojos.User;
import com.app.repositiory.ICartItemRepository;
import com.app.repositiory.IOrderRepositiory;
import com.app.repositiory.IPaymentRepositary;
import com.app.service.user.IUserService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
@Transactional
public class OrderServiceImple implements IOrderServices {

	
	@Autowired
	private IOrderRepositiory orderRepo;
	
	@Autowired
	private IUserService userServices;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ICartItemRepository cartRepo;
	
	@Autowired
	private IPaymentRepositary paymentRepo;
	
	@Override
	public Orders getOrders(Long id) {
	 return orderRepo.findById(id).get();
		
	}
	
		@Override
		public List<Orders> getOrderList(Long Userid) {
//			log.info("In order service implimentaion : get list of orders by userID");
			Userdto existUser = userServices.getUserById(Userid);
			return orderRepo.findByUser(mapper.map(existUser, User.class));
		}

		@Override
		public String createOrderByUserCart(Long id, Address address, PaymentType paymentType) throws RazorpayException {

			Orders newOrder = new Orders();
			Userdto cust = userServices.getUserById(id);
			User customer = mapper.map(cust, User.class);
			System.out.println(customer);
			List<CartItem> cartItems = cartRepo.findByCurrentUser(customer);
			
			if (paymentType.equals(PaymentType.ONLINE)) {
				newOrder.setOrderStatus(OrderStatus.PROCESSING);
			} else {
				newOrder.setOrderStatus(OrderStatus.PROCESSING);
			}
			newOrder.setUser(customer);
			newOrder.setDeliveryAddress(address);
			Set<OrderDetails> orderDetails = newOrder.getOrderDetails();
			double totalAmount = 0;
			// place order for products in cart
			for (CartItem cartItem : cartItems) {
				Products product = cartItem.getProducts();
				// Decrease the stock of product
				decreaseStock(product, cartItem.getQuantity());
				OrderDetails orderDetail = new OrderDetails();
				orderDetail.setOrder(newOrder);
				orderDetail.setProduct(product);
				orderDetail.setProductName(product.getProdName());
				orderDetail.setQuantity(cartItem.getQuantity());
				orderDetail.setUnitPrice(product.getUnitPrice());
				orderDetail.setSubtotal(product.getUnitPrice() * cartItem.getQuantity());
				totalAmount = totalAmount + orderDetail.getSubtotal();
				orderDetails.add(orderDetail);

				// now delete the entires from cart
				cartRepo.deleteByCurrentUserAndProducts(customer.getId(), product.getId());
			}

			// set payment details
			Payment payment = new Payment();
			payment.setOrder(newOrder);
			payment.setPaymentStatus(PaymentStatus.PAID);
			payment.setPaymentType(paymentType.ONLINE);
			payment.setPaymentDate(LocalDate.now());
			paymentRepo.save(payment);
//			log.info(payment.toString());
			double amt = totalAmount;

			// set razor pay details
			var client = new RazorpayClient("rzp_test_DIePDruxfVbZye", "IOfRw9z3m2HRtNthiqMZ7ruN");
			Random rnd = new Random();
			int txn = rnd.nextInt(999999999);

			JSONObject ob = new JSONObject();
			ob.put("amount", amt * 100);
			ob.put("currency", "INR");
			ob.put("receipt", "txn_" + txn);

			com.razorpay.Order rz_order = client.Orders.create(ob);
			System.out.println(rz_order);

			String ids = rz_order.get("id");
			newOrder.setRazorPayOrderId(ids);
			newOrder.setTotalAmount(totalAmount);
			orderRepo.save(newOrder);
			return rz_order.toString();

		}
		
		
		// Method to decrease the product stock
		public void decreaseStock(Products product, int quantity) {
//			log.info("In order service implimentaion : decearese stock method");
			int oldQuantity = product.getProdQuantity();
			
			if (oldQuantity > 0 && oldQuantity > quantity) {
				int updatedQuantity = (oldQuantity - quantity);
				product.setProdQuantity(updatedQuantity);
//				log.info("After placed order : " + product);
			} else {
				throw new UserHandlingException(
						"Out of stock .........for product" + product.getProdName() + "availble stock : " + oldQuantity);
			}
		}

		


		
}
