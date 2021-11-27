package com.teamzion.bethelbakery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.CartItem;
import com.teamzion.bethelbakery.models.Customer;
import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.repositories.CartItemRepository;
import com.teamzion.bethelbakery.repositories.ProductRepository;

//*****************
//*CartItemService*
//*****************

//Implementation for cartItems
@Service
public class CartItemService {

	//*************
	//*Data fields*
	//*************
	
	@Autowired
	private CartItemRepository cartRepository;
	
	
	//*********
	//*Methods*
	//*********
	
	//Add item to cart
	public ResponseEntity<CartItem> addItemToCart(CartItem cartItem){
		CartItem newCartItem = cartRepository.save(cartItem);
		return ResponseEntity.ok(newCartItem);
	}//End method
	
	//Get all items by customer
	public List<CartItem> getAllItemsByCustomer(Integer id){
		List<CartItem> allCartItems = cartRepository.findAll();
		return findAllCartItemsCustomerId(allCartItems, id);
	}//End method

	//loop through all cart items to find cart items by customer id
	public List<CartItem> findAllCartItemsCustomerId(List<CartItem> allCartItems, Integer id){
		List<CartItem> allCartItemsByCustomer = new ArrayList<CartItem>();
		
		for(int i = 0; i < allCartItems.size(); i ++) {
			
			if(allCartItems.get(i).getCustomer().getId() == id) {
				allCartItemsByCustomer.add(allCartItems.get(i));
			}//End if
		
		}//End loop
		
		return allCartItemsByCustomer;
		
	}//End method
	
	//Delete cart item by id
	public ResponseEntity<CartItem> deleteCartItem(Integer id){
		CartItem foundCartItem = cartRepository.findById(id).orElse(null);
		
		if(foundCartItem == null) {
			return ResponseEntity.notFound().header("Cart Item", "Nothing found with that id").build();
		}//End if
		
		else {
			cartRepository.delete(foundCartItem);
		}//End else 
		
		return ResponseEntity.ok(foundCartItem);
		
	}//End method
	
}//End Class
