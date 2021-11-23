package com.teamzion.bethelbakery.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//Model for Cart
@Entity
@Table(name = "cart_items")
public class CartItem {
	
	//Data Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_items_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	@JsonBackReference
	private Product product;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "sub_total")
	private double subTotal;
	
	//TODO map customer
//	private Customer customer;
	
	//TODO map orders
//	private Order order;

	//Constructors
	public CartItem() {}

	public CartItem(Product product, int productQuantity, double subTotal, Customer customer, Order order) {
		this.product = product;
		this.productQuantity = productQuantity;
		this.subTotal = subTotal;
//		this.customer = customer;
//		this.order = order;
	}

	//Setters And Getters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}

	public int getId() {
		return id;
	}

	//To String
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", product=" + product + ", productQuantity=" + productQuantity + ", subTotal="
				+ subTotal + ", customer="
//				+ customer + ", order=" + order + "]"
				;
	}
}
