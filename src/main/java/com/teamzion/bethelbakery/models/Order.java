package com.teamzion.bethelbakery.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//*******
//*order*
//*******

//model for order
@Entity
@Table(name = "orders")
public class Order {
	
	//*************
	//*Data fields*
	//*************
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany()
	@JoinColumn(name = "order_id")
	private List<CartItem> cartItems;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "credit_card")
	private String creditCardNumber;
	
	@Column(name = "expiration")
	private String expiration;
	
	@Column(name = "ccv")
	private int ccv;
	
	@Column(name = "sub_total")
	private double subTotal;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "date")
	private String dateTimeStamp;
	
	
	
	//**************
	//*Constructors*
	//**************
	
	public Order() {}
	
	public Order(int id, User user, List<CartItem> cartItems, String firstName, String lastName, String email,
			String phoneNumber, String address, String creditCardNumber, String expiration, int ccv, double subTotal,
			double total, String dateTimeStamp) {
		this.id = id;
		this.user = user;
		this.cartItems = cartItems;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creditCardNumber = creditCardNumber;
		this.expiration = expiration;
		this.ccv = ccv;
		this.subTotal = subTotal;
		this.total = total;
		this.dateTimeStamp = dateTimeStamp;
	}

	//*********
	//*Methods*
	//*********

	//Getter for cartItems
	public List<CartItem> getCartItems() {
		return cartItems;
	}//End method

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Setter for cartItems
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}//End method

	//Getter for firstName
	public String getFirstName() {
		return firstName;
	}//End method

	//Setter for firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}//End method

	//Getter for lastName
	public String getLastName() {
		return lastName;
	}//End method

	//Setter for lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}//End method

	//Getter for email
	public String getEmail() {
		return email;
	}//End method

	//Setter for email
	public void setEmail(String email) {
		this.email = email;
	}//End method

	//Getter for Address
	public String getAddress() {
		return address;
	}//End method

	//Setter for address
	public void setAddress(String address) {
		this.address = address;
	}//End method

	//Getter for creditCardNumber
	public String getCreditCardNumber() {
		return creditCardNumber;
	}//End method

	//Setter for creditCardNumber
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}//End method

	//Getter for Expiration
	public String getExpiration() {
		return expiration;
	}//End method

	//Setter for Expiration
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}//End method

	//Getter for ccv
	public int getCcv() {
		return ccv;
	}//End method

	//Setter for ccv
	public void setCcv(int ccv) {
		this.ccv = ccv;
	}//End method

	//Getter for subTotal
	public double getSubTotal() {
		return subTotal;
	}//End method

	//Setter for subTotal
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}//End method

	//Getter for total
	public double getTotal() {
		return total;
	}//End method

	//Setter for total
	public void setTotal(double total) {
		this.total = total;
	}//End method

	//Getter for dateTimeStamp
	public String getDateTimeStamp() {
		return dateTimeStamp;
	}//End method

	//Setter for dateTimeStamp
	public void setDateTimeStamp(String dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}//End method

	//Getter for id
	public int getId() {
		return id;
	}//End method

	//Getter for phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}//End method

	//Setter for phoneNumber
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}//End method

	

}//End class
