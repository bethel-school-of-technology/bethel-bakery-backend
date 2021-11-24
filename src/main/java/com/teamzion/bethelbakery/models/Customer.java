package com.teamzion.bethelbakery.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//**********
//*CartItem*
//**********

//The model for customer
@Entity
@Table(name="customers")
public class Customer {
	
	//*************
	//*Data fields*
	//*************
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
		
	@Column(name = "user_name")
	private String userName;
		
	@Column(name = "passward")
	private String password;
		
	@Column(name = "is_admin")
	private boolean isAdmin;
	
	
	//*************
	//*Constructor*
	//*************
	
	public Customer() {}

	public Customer(String userName, String passward, boolean isAdmin, List<CartItem> cartItems, List<Order> orders) {
		this.userName = userName;
		this.password = passward;
		this.isAdmin = isAdmin;
	}


	//*********
	//*Methods*
	//*********
	
	//Getter for userName
	public String getUserName() {
		return userName;
	}//End method

	//Setter for userName
	public void setUserName(String userName) {
		this.userName = userName;
	}//End method

	//Getter for password
	public String getPassword() {
		return password;
	}//End method

	//Setter for password
	public void setPassword(String password) {
		this.password = password;
	}//End method

	//Getter for isAdmin
	public boolean isAdmin() {
		return isAdmin;
	}//End method

	//Setter for isAdmin
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}//End method

	//Getter for id
	public int getId() {
		return id;
	}//End method

	//ToString method
	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", passward=" + password + ", isAdmin=" + isAdmin
				+ "]";
	}//End method	
		
}//End class
