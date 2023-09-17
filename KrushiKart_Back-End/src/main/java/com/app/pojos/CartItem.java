package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart_items")

public class CartItem extends BaseEntity {

	@CreationTimestamp 
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products products;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private User currentUser;
	
	private int quantity;

	public CartItem(LocalDate createdOn, Products products, User currentUser, int quantity) {
		super();
		this.createdOn = createdOn;
		this.products = products;
		this.currentUser = currentUser;
		this.quantity = quantity;
	}

	public CartItem() {
		super();
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [createdOn=" + createdOn + ", products=" + products + ", currentUser=" + currentUser
				+ ", quantity=" + quantity + "]";
	}
	
	@Transient
	public double getTotalOfProduct() {
		return products.getUnitPrice() * quantity;
	}


	
	
}
