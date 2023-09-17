package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Getter
//@Setter
public class Orders extends BaseEntity {
	
	@CreationTimestamp 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate deliveryDate;
	
	@Column(name="total_Amount")
	private double totalAmount;
	
	private String razorPayOrderId;

	// one user can put many orders
	@ManyToOne
	@JoinColumn(name = "Customer_id")
	private User user;

	// many order can assigned to one deliveryBoy
	
	@OneToOne
	@JoinColumn(name = "delivery_boy_id")
	private DeliveryBoy deliverBoy;

	// one order can have one delivery address
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_addr_id")
	private Address deliveryAddress;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderDetails> orderDetails = new HashSet<>();

	// Argumented consutructor

	public Orders(double totalAmount, LocalDate orderDate, OrderStatus orderStatus, LocalDate deliveryDate,
			User customer, DeliveryBoy deliverBoy, Address deliveryAddress, Set<OrderDetails> orderItems,String razorId) {
		super();
		this.totalAmount = totalAmount;
		this.orderDate = LocalDate.now();
		this.orderStatus = orderStatus;
		this.deliveryDate = this.orderDate.plusDays(1);
		this.user = customer;
		this.deliverBoy = deliverBoy;
		this.deliveryAddress = deliveryAddress;
		this.orderDetails = orderItems;
		this.razorPayOrderId= razorId;
	}

	// No args constructor
	public Orders() {
		super();
		this.orderDate = LocalDate.now();
		this.deliveryDate = this.orderDate.plusDays(1);
	}

	@Override
	public String toString() {
		return "Order [totalAmount=" + totalAmount + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", deliveryDate=" + deliveryDate + "]";
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRazorPayOrderId() {
		return razorPayOrderId;
	}

	public void setRazorPayOrderId(String razorPayOrderId) {
		this.razorPayOrderId = razorPayOrderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DeliveryBoy getDeliverBoy() {
		return deliverBoy;
	}

	public void setDeliverBoy(DeliveryBoy deliverBoy) {
		this.deliverBoy = deliverBoy;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	

	

}
