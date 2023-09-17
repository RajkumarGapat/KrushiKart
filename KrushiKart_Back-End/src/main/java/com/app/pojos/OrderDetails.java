
package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "order_details")
public class OrderDetails extends BaseEntity {

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Orders order;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products product;
	//private List<Products> productlist=new ArrayList<Products>();
	

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	// min order quantity 1
	private int quantity;

	private double unitPrice;

	// specified total or perticular product according to there quantity
	private double subtotal;

	private String productName;

	// to-string method

	@Override
	public String toString() {
		return "OrderItems [quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

	public OrderDetails(Orders order, int quantity, double unitPrice, double subtotal, String productName) {
		super();
		this.order = order;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.subtotal = subtotal;
		this.productName = productName;
	}

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

}
