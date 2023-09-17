package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import com.app.pojos.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ProductDto extends JpaRepositoriesAutoConfiguration {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@NotEmpty(message = "Product name must be supplied")
	private String prodName;
	
	@NotEmpty(message = "Product Description must be supplied")
	private String prodDesc;
	
	
	private double unitPrice;
	
	private int prodQuantity;
	
	private String imageUrl;
	
	private double prodWeight;
	
	private String special_specification;
	
	private LocalDate mfgDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	

}
