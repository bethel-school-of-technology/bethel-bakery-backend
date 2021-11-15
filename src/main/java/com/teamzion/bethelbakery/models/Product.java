package com.teamzion.bethelbakery.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//Model to hold product information
@Entity
@Table(name="products")
public class Product {
	
	//Data fields 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "img_url")
	private String imgUrl;
	
	//Constructor
	public Product() {}

	public Product(String name, double price, String imgUrl) {
		super();
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	//Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

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

	//ToString
	@Override
	public String toString() {
		return "ProductsModel [productId=" + productId + ", name=" + name + ", price=" + price + ", imgUrl=" + imgUrl
				+ "]";
	}
}
