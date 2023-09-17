package com.app.pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="seller_prod_tbl")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class ProductSeller extends BaseEntity{
	
	@Column(name="prod_Name",length = 100,nullable = false)
	private String productName;
	
	@Column(name="prod_Desc",length = 100,nullable = false)
	private String productDesc;
	
	@Column(name="prod_Compamy_Name",length = 100,nullable = false)
	private String prodCompanyName;
	
	@Column(name="prod_Price",nullable = true)
	private double prodPrice;
	
	@Column(name="prod_Quantity",nullable = true)
	private int prodQuantity;
	
	@Column(name="prod_Image",nullable = true)
	private byte[] prodImage;
	
	@Column(name="other_prod_spec")
	private String prodSpecification;
	
//	@JsonIgnore
//	@ManyToMany
////	@JoinColumn(name="prod_id")
//	private List<Products> productList=new ArrayList<Products>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="seller_prod_list",
					joinColumns=@JoinColumn(name="product_id"),
					inverseJoinColumns = @JoinColumn(name = "seller_id"))
	private List<Products> productList=new ArrayList<>();

public ProductSeller(String productName, String productDesc, String prodCompanyName, double prodPrice, int prodQuantity,
		byte[] prodImage, String prodSpecification, List<Products> productList) {
	super();
	this.productName = productName;
	this.productDesc = productDesc;
	this.prodCompanyName = prodCompanyName;
	this.prodPrice = prodPrice;
	this.prodQuantity = prodQuantity;
	this.prodImage = prodImage;
	this.prodSpecification = prodSpecification;
	this.productList = productList;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductDesc() {
	return productDesc;
}

public void setProductDesc(String productDesc) {
	this.productDesc = productDesc;
}

public String getProdCompanyName() {
	return prodCompanyName;
}

public void setProdCompanyName(String prodCompanyName) {
	this.prodCompanyName = prodCompanyName;
}

public double getProdPrice() {
	return prodPrice;
}

public void setProdPrice(double prodPrice) {
	this.prodPrice = prodPrice;
}

public int getProdQuantity() {
	return prodQuantity;
}

public void setProdQuantity(int prodQuantity) {
	this.prodQuantity = prodQuantity;
}

public byte[] getProdImage() {
	return prodImage;
}

public void setProdImage(byte[] prodImage) {
	this.prodImage = prodImage;
}

public String getProdSpecification() {
	return prodSpecification;
}

public void setProdSpecification(String prodSpecification) {
	this.prodSpecification = prodSpecification;
}

public List<Products> getProductList() {
	return productList;
}

public void setProductList(List<Products> productList) {
	this.productList = productList;
}

@Override
public String toString() {
	return "ProductSeller [productName=" + productName + ", productDesc=" + productDesc + ", prodCompanyName="
			+ prodCompanyName + ", prodPrice=" + prodPrice + ", prodQuantity=" + prodQuantity + ", prodImage="
			+ Arrays.toString(prodImage) + ", prodSpecification=" + prodSpecification + ", productList=" + productList
			+ ", getId()=" + getId() +  "]";
}
	
	
	
}
