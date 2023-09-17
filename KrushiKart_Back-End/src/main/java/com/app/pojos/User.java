package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
//will be importing all annotations from this pkg
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users_tbl")
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString(exclude = {"cart"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "user_id")
	private Long id;

	@Length(min = 4, max = 20, message = "Invalid or Blank first name!!!!!!")
	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 20)
	@NotBlank(message = "Last  name can't be blank")
	private String lastName;

	@Column(length = 50, unique = true)
	private String email;

	@Column(name = "user_age")
	private int age;

	@Column(length = 100, nullable = false)
	private String password;

	// @Length(min=10,message = "please enter valid contact number")
	@Column(name = "conact_No", nullable = true, length = 25, unique = true)
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", length = 30)
	private Role userRole;

	@ReadOnlyProperty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DateOfBirth", nullable = false)
	private LocalDate DOB;

//	@Column(length = 20)
//	private String city;
//	@Column(length = 20)
//	private String state;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_address")
	private Address address;

	@JsonIgnore
	@OneToMany(mappedBy = "currentUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> cartItemList = new ArrayList<CartItem>();

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}


	public User() {
		super();
	}

	public User(Long id, @Length(min = 4, max = 20, message = "Invalid or Blank first name!!!!!!") String firstName,
			@NotBlank(message = "Last  name can't be blank") String lastName, String email, int age, String password,
			String contactNumber, Role userRole, LocalDate dOB, Address address, List<CartItem> cartItemList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.password = password;
		this.contactNumber = contactNumber;
		this.userRole = userRole;
		DOB = dOB;
		this.address = address;
		this.cartItemList = cartItemList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age="
				+ age + ", password=" + password + ", contactNumber=" + contactNumber + ", userRole=" + userRole
				+ ", DOB=" + DOB + ", address=" + address + ", cartItemList=" + cartItemList + "]";
	}


}
