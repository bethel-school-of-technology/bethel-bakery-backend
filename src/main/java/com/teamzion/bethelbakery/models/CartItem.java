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
	@JoinColumn(name="customer_id")
	private Customer customer;

	//**************
	//*Constructors*
	//**************
	public CartItem() {}

	public CartItem(Product product, int productQuantity, double subTotal, Customer customer) {
		this.product = product;
		this.productQuantity = productQuantity;
		this.subTotal = subTotal;
		this.customer = customer;
	}
	
	//*********
	//*Methods*
	//*********

	//Getter for product
	public Product getProduct() {
		return product;
	}//End method

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

	//Getter for customer
	public Customer getCustomer() {
		return customer;
	}//End method

	//Setter for customer
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}//End method

	//Getter for id
	public int getId() {
		return id;
	}//End method

	//To String for debugging
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", product=" + product + ", productQuantity=" + productQuantity + ", subTotal="
				+ subTotal + ", customer="+ customer + "]";
	}//End method

}//End Class
