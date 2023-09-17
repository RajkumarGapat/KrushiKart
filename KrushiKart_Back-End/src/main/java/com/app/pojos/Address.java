package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Embeddable 
@Entity
@Table(name="address_tbl")
//@Getter
//@Setter
//@ToString
@Validated


public class Address extends BaseEntity{
	private int unit_number;
	@NotNull
	private int street_number;
	@Column(length = 100)
	@NotBlank
	private String addressLine1;
	@Column(length = 100)
	private String addressLine2;
	@Column(length = 30)
	@NotBlank
	private String city;
	
	@Column(length = 30)
	@NotBlank
	private String state;
	
	@NotNull
	private int postalCode;
	@Column(length = 30)
	@NotBlank
	private String country;
	
	public Address(int unit_number, @NotNull int street_number, @NotBlank String addressLine1, String addressLine2,
			@NotBlank String city, @NotBlank String state, @NotNull int postalCode, @NotBlank String country) {
		super();
		this.unit_number = unit_number;
		this.street_number = street_number;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Address() {
		super();
	}

	public int getUnit_number() {
		return unit_number;
	}

	public void setUnit_number(int unit_number) {
		this.unit_number = unit_number;
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [unit_number=" + unit_number + ", street_number=" + street_number + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + "]";
	}
	
	
	
//	@JoinColumn(name="order_id")
//	@OneToOne(cascade = CascadeType.ALL)
//	private Orders orders;
	
	
}
