//package com.app.pojos;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//
//
////@Getter
////@Setter
//@ToString(exclude = {"cartOwner","cartItems"})
//public class ShoppingCart extends BaseEntity {
//
//	@Column(name = "total_items")
//	private int totalItems;
//	
//	@Column(name = "total_cart_price")
//	private double totalCartPrice;
//	
//	@CreationTimestamp 
//	@Column(name = "created_on")
//	private LocalDate createdOn;
//	
//	@UpdateTimestamp 
//	@Column(name = "last_updated_on")
//	private LocalDate lastUpdatedOn;
//	// Cart HAS-A Customer Cart ----> User
//	// Cart : one , child , owning
//	@JsonIgnore
//	@OneToOne 
//	@JoinColumn(name = "customer_id", nullable = false)
//	private User cartOwner;
//	// Cart *--->* Product	
//	//Cart ---> CartItems : one to many
////	@JsonIgnore
////	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
////	private List<CartItem> cartItems=new ArrayList<>();
//	
//	public ShoppingCart(int totalItems, double totalCartPrice, LocalDate createdOn, LocalDate lastUpdatedOn,
//			User cartOwner, List<CartItem> cartItems) {
//		super();
//		this.totalItems = totalItems;
//		this.totalCartPrice = totalCartPrice;
//		this.createdOn = createdOn;
//		this.lastUpdatedOn = lastUpdatedOn;
//		this.cartOwner = cartOwner;
//		
//	}
//
//	public ShoppingCart() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getTotalItems() {
//		return totalItems;
//	}
//
//	public void setTotalItems(int totalItems) {
//		this.totalItems = totalItems;
//	}
//
//	public double getTotalCartPrice() {
//		return totalCartPrice;
//	}
//
//	public void setTotalCartPrice(double totalCartPrice) {
//		this.totalCartPrice = totalCartPrice;
//	}
//
//	public LocalDate getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(LocalDate createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	public LocalDate getLastUpdatedOn() {
//		return lastUpdatedOn;
//	}
//
//	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
//		this.lastUpdatedOn = lastUpdatedOn;
//	}
//
//	public User getCartOwner() {
//		return cartOwner;
//	}
//
//	public void setCartOwner(User cartOwner) {
//		this.cartOwner = cartOwner;
//	}
//
//	
//	
//	
//}
