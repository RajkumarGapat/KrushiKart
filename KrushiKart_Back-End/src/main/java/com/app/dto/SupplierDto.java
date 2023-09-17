package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



public class SupplierDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank
	@Email(message = "Invalid Email")
	private String email;

	@NotEmpty(message = "First name must be supplied")
	@Length(min = 4, max = 30, message = "Invalid First name length")
	private String firstName;

	@NotBlank(message = "Last name must be supplied")
	private String lastName;

	@JsonProperty(access = Access.WRITE_ONLY) // for de-serial only
	private String password;

	@Past(message = "Date of birth  msut be in past")
	private LocalDate DOB;

	@Digits(message = "Number should contain 10 digits.", fraction = 0, integer = 10)
	private String mobNo;

	private String city;

	private String state;

	@NotNull
	private Role role;

	@NotBlank(message = "GST number must be supplied")
	private String GSTNO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGSTNO() {
		return GSTNO;
	}

	public void setGSTNO(String gSTNO) {
		GSTNO = gSTNO;
	}

	@Override
	public String toString() {
		return "SupplierDto [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", DOB=" + DOB + ", mobNo=" + mobNo + ", city=" + city + ", state=" + state
				+ ", role=" + role + ", GSTNO=" + GSTNO + "]";
	}
	
	

}
