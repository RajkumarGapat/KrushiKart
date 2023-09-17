package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@DiscriminatorValue(value = "deliveryBoy")
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "deliveryBoy")
@Entity

public class DeliveryBoy extends User {

	@Column(length = 40)
	private String licenseNO;
	
	public String getLicenseNO() {
		return licenseNO;
	}

	public void setLicenseNO(String licenseNO) {
		this.licenseNO = licenseNO;
	}

	

	// No-Agrs constructor
	public DeliveryBoy() {
		super();

	}

	public DeliveryBoy(String licenseNO) {
		super();
		this.licenseNO = licenseNO;
	}

	@Override
	public String toString() {
		return "DeliveryBoy [licenseNO=" + licenseNO + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getAge()=" + getAge()
				+ ", getPassword()=" + getPassword() + ", getContactNumber()=" + getContactNumber() + ", getUserRole()="
				+ getUserRole() + ", getDOB()=" + getDOB() + ", getCart()=" + ", getAddress()="
				+ getAddress() + ", toString()=" + super.toString() + 
				 "]";
	}


	


}
