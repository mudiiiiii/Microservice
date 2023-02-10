package com.assignmentfour;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table (name = "Customer")
public class Customer {
	@Id
	@SequenceGenerator(name="cus_seq", sequenceName="customer_seq") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cus_seq")
	@Column (name="custid")
	private int custID;
	
	@Column (name = "firstname" )
	@NotBlank(message = "First name is mandatory")
	private String firstName;
	
	@Column (name = "lastname" )
	@NotBlank(message = "Last name is mandatory")
	private String lastName;
	
	@Column (name = "address" )
	@NotBlank(message = "Address is mandatory")
	private String address;
	
	@Column (name = "city" )
	@NotBlank(message = "City is mandatory")
	private String city;
	
	@Column (name = "country" )
	@NotBlank(message = "Country is mandatory")
	private String country;
	
	@Column (name = "phone" )
	@NotBlank(message = "Phone number is mandatory")
	private String phone;
	
	@Column (name = "email" )
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@Column (name = "username" )
	@NotBlank(message = "User name is mandatory")
	private String username;
	
	@Column (name = "password" )
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	public Customer() {
		super();
	}
	
	public Customer(@NotBlank(message = "User name is mandatory") String username,
			@NotBlank(message = "Password is mandatory") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
