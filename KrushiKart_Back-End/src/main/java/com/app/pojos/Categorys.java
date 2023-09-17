package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name="category_tbl")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Categorys extends BaseEntity{
	
	@Column(name="cat_Name",length = 50,nullable = false,unique = true)
	private String categoryName;
	@Column(name="cat_Desc",length = 200,nullable = false)
	private String categoryDesc;
	@Column(name="active")
	private boolean activeStatus;
	
	@Column(length = 150)
	private String imageUrl;
	
	@JsonIgnore
	@OneToMany(mappedBy = "prodCategory", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Products> productsList = new ArrayList<>();
	





	public Categorys(String categoryName, String categoryDesc, boolean activeStatus, String imageUrl,
			List<Products> productsList) {
		super();
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.activeStatus = activeStatus;
		this.imageUrl = imageUrl;
		this.productsList = productsList;
	}



	public Categorys() {
		super();
	}



	@Override
	public String toString() {
		return "Categorys [categoryName=" + categoryName + ", categoryDesc=" + categoryDesc + ", activeStatus="
				+ activeStatus + ", imageUrl=" + imageUrl + ", productsList=" + productsList + "]";
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getCategoryDesc() {
		return categoryDesc;
	}



	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}



	public boolean isActiveStatus() {
		return activeStatus;
	}



	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public List<Products> getProductsList() {
		return productsList;
	}



	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}



	//helper method
	public void addProduct(Products prod) {
		this.productsList.add(prod);

	}


	

}
