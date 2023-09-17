package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;

@Entity

@Table(name = "purchase_bill")
public class PurchaseBill extends BaseEntity {

	private double totalAmount;

	@ReadOnlyProperty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate billDate;

	@OneToOne
	@JoinColumn(name = "seller_id")
	private ProductSeller supplier;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Products product;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate manfDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expDate;

	@Column(length = 30)
	private String batchNo;

	private int quantity;

	private double unitPrice;

	public PurchaseBill(double totalAmount, ProductSeller supplier) {
		super();
		this.billDate = LocalDate.now();
		this.supplier = supplier;

	}

	public PurchaseBill() {
		super();
		this.billDate = LocalDate.now();

	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = (this.unitPrice * this.quantity);
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public void setSupplier(ProductSeller supplier) {
		this.supplier = supplier;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public void setManfDate(LocalDate manfDate) {
		this.manfDate = manfDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public ProductSeller getSupplier() {
		return supplier;
	}

	public Products getProduct() {
		return product;
	}

	public LocalDate getManfDate() {
		return manfDate;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public PurchaseBill(double totalAmount, LocalDate billDate, ProductSeller supplier, Products product,
			LocalDate manfDate, LocalDate expDate, String batchNo, int quantity, double unitPrice) {
		super();
		this.totalAmount = totalAmount;
		this.billDate = billDate;
		this.supplier = supplier;
		this.product = product;
		this.manfDate = manfDate;
		this.expDate = expDate;
		this.batchNo = batchNo;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	

}
