package com.app.pojos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "supplier")
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "seller_Reg")
public class SellerReg extends User{
	
	private String GSTNO;

	public SellerReg() {
		super();
	}

	@Override
	public String toString() {
		return "SellerReg [GSTNO=" + GSTNO + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getAge()=" + getAge()
				+ ", getPassword()=" + getPassword() + ", getContactNumber()=" + getContactNumber() + ", getUserRole()="
				+ getUserRole() + ", getDOB()=" + getDOB() + ", getCity()=" +  ", getState()=" 
				+ ", getCart()=" +  ", getAddress()=" + getAddress() + ", toString()=" + "]";
	}

	public SellerReg(String gSTNO) {
		super();
		GSTNO = gSTNO;
	}
	



	
	
	

}
