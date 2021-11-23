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

//Model to hold product information
@Entity
@Table(name="products")
public class Product {
	
	//Data fields 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	@Column(name = "product_name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "img_url")
	private String imgUrl;
	
	
	@OneToMany(mappedBy = "product")
	@JsonManagedReference
	private List<CartItem> cartItem;
	 
	//Constructor
	public Product() {}
	
	public Product(String name, double price, String imgUrl, List<CartItem> cartItem) {
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
		this.cartItem = cartItem;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public int getId() {
		return id;
	}

	//To String
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", imgUrl=" + imgUrl + ", cartItem="
				+ cartItem + "]";
	}
}
