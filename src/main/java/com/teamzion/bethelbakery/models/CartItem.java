package com.teamzion.bethelbakery.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//**********
//*CartItem*
//**********

//Model for Cart items
@Entity
@Table(name = "cart_items")
public class CartItem {
	
	//*************
	//*Data Fields*
	//*************
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_items_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "sub_total")
	private double subTotal;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//**************
	//*Constructors*
	//**************
	public CartItem() {}
	
	public CartItem(int id, Product product, int productQuantity, double subTotal, User user) {
		super();
		this.id = id;
		this.product = product;
		this.productQuantity = productQuantity;
		this.subTotal = subTotal;
		this.user = user;
	}

	//*********
	//*Methods*
	//*********

	
	//Getter for product
	public Product getProduct() {
		return product;
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

	//Setter for product
	public void setProduct(Product product) {
		this.product = product;
	}//End method

	//Getter for productQuantity
	public int getProductQuantity() {
		return productQuantity;
	}//End method
	
	//Setter for productQuantity
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}//End method

	//Getter for subTotal
	public double getSubTotal() {
		return subTotal;
	}//End method

	//Setter for subTotal
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}//End method

	//Getter for id
	public int getId() {
		return id;
	}//End method

}//End Class
