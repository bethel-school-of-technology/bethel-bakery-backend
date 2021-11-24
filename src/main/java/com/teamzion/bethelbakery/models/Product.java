package com.teamzion.bethelbakery.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//*********
//*Product*
//*********

//Model for products
@Entity
@Table(name="products")
public class Product {
	
	//*************
	//*Data fields*
	//*************
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
	
	
	//*************
	//*Constructor*
	//*************
	public Product() {}
	
	public Product(String name, double price, String imgUrl, List<CartItem> cartItem) {
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}//End Constructor

	
	//*********
	//*Methods*
	//*********
	
	//Getter for name
	public String getName() {
		return name;
	}//End method

	//Setter for name
	public void setName(String name) {
		this.name = name;
	}//End method

	//Getter for price
	public double getPrice() {
		return price;
	}//End method

	//Setter for price
	public void setPrice(double price) {
		this.price = price;
	}//End method

	//Getter for imgUrl
	public String getImgUrl() {
		return imgUrl;
	}//End method

	//Setter for imgUrl
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}//End method

	//Getter for id
	public int getId() {
		return id;
	}//End method

	//To String
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", imgUrl=" + imgUrl + "]";
	}//End method
	
}//End class
