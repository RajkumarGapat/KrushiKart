package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prod_tbl")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Products extends BaseEntity {

	@Column(name = "prod_Name", length = 200, nullable = false)
	private String prodName;

	@Column(name = "prod_Desc", length = 500, nullable = false)
	private String prodDesc;

	@Column(name = "prod_price", nullable = false)
	private double unitPrice;

	@Column(name = "prod_Quantity", nullable = false)
	private int prodQuantity;

	@Column(length = 150)
	private String imageUrl;

	@Column(name = "prod_weight")
	private double prodWeight;

	@Column(name = "Special_Specification", length = 500)
	private String special_specification;

	@Column(name = "manufacture_Date")
	private LocalDate mfgDate;

	// for category we use bi-directional trancation
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Category_cid")
	private Categorys prodCategory;

	@JsonIgnore
	@OneToMany
	//@JoinTable(name = "orders_like", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "orderDetails_id"))
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "products", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> cartItemList=new ArrayList<CartItem>();
//	@JsonIgnore
//	@ManyToMany
//	@JoinTable(name="seller_prod_likes",
//					joinColumns=@JoinColumn(name="product_ids"),
//					inverseJoinColumns = @JoinColumn(name = "seller_id"))
//	private List<ProductSeller> sellerProdList=new ArrayList<ProductSeller>();

	// ***************************************
	// hepler method for adding seed category
	public void addNewCategory(Categorys CatObj) {
		this.setProdCategory(CatObj);

	}

	

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}



	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}



	public Products() {
	super();
}



	public Products(String prodName, String prodDesc, double unitPrice, int prodQuantity, String imageUrl,
		double prodWeight, String special_specification, LocalDate mfgDate, Categorys prodCategory,
		List<OrderDetails> orderDetails, List<CartItem> cartItemList) {
	super();
	this.prodName = prodName;
	this.prodDesc = prodDesc;
	this.unitPrice = unitPrice;
	this.prodQuantity = prodQuantity;
	this.imageUrl = imageUrl;
	this.prodWeight = prodWeight;
	this.special_specification = special_specification;
	this.mfgDate = mfgDate;
	this.prodCategory = prodCategory;
	this.orderDetails = orderDetails;
	this.cartItemList = cartItemList;
}



	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getProdWeight() {
		return prodWeight;
	}

	public void setProdWeight(double prodWeight) {
		this.prodWeight = prodWeight;
	}

	public String getSpecial_specification() {
		return special_specification;
	}

	public void setSpecial_specification(String special_specification) {
		this.special_specification = special_specification;
	}

	public LocalDate getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Categorys getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(Categorys prodCategory) {
		this.prodCategory = prodCategory;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Products [prodName=" + prodName + ", prodDesc=" + prodDesc + ", unitPrice=" + unitPrice
				+ ", prodQuantity=" + prodQuantity + ", imageUrl=" + imageUrl + ", prodWeight=" + prodWeight
				+ ", special_specification=" + special_specification + ", mfgDate=" + mfgDate + ", prodCategory="
				+ prodCategory + ", orderDetails=" + orderDetails + "]";
	}

	

}