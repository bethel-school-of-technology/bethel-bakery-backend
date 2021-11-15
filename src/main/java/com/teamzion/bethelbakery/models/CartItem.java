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

//Model for Cart
@Entity
@Table(name = "cart")
public class CartItem {
	
	//Data Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name = "product_quantity")
	private int productQuantity;

	//Constructors
	public CartItem() {}

	public CartItem(Product product, int productQuantity) {
		this.product = product;
		this.productQuantity = productQuantity;
	}

	//Setters And Getters
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

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

	//To String
	@Override
	public String toString() {
		return "CartModel [cartId=" + cartId + ", product=" + product + ", productQuantity=" + productQuantity + "]";
	}
}
