package com.teamzion.bethelbakery.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	//Data fields 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
		
	@Column(name = "user_name")
	private String userName;
		
	@Column(name = "passward")
	private String passward;
		
	@Column(name = "is_admin")
	private boolean isAdmin;

	//Constructor
	public Customer() {}

	public Customer(String userName, String passward, boolean isAdmin) {
		this.userName = userName;
		this.passward = passward;
		this.isAdmin = isAdmin;
	}

	//Getters and Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	//ToString method
	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", passward=" + passward + ", isAdmin=" + isAdmin
				+ "]";
	}
		
}
