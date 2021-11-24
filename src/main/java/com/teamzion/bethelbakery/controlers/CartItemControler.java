package com.teamzion.bethelbakery.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamzion.bethelbakery.models.CartItem;
import com.teamzion.bethelbakery.models.Customer;
import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.services.CartItemService;
import com.teamzion.bethelbakery.services.ProductsService;

//*******************
//*CartItemControler*
//*******************

//This class handles the mappings for cart items API
@RestController 
public class CartItemControler {
		
	//*************
	//*Data Fields*
	//*************
	
	@Autowired
	private CartItemService cartservice;//handles implementation of this class
	
	
	//*********
	//*Methods*
	//*********
	
	//Get Request to get all cart items by customer id.
	@CrossOrigin
	@GetMapping("/cartitem/{customerid}") 
	public List<CartItem> getAllCartItemsByCustomer(@PathVariable(value="customerid") Integer id){
		return cartservice.getAllItemsByCustomer(id);
	}//End Method
	
	//Post request to add new item to cart
	@CrossOrigin
	@PostMapping("/cartitem")
	public ResponseEntity<CartItem> addNewItemToCart(@RequestBody CartItem cartItem) {
		return cartservice.addItemToCart(cartItem);
	}//End method
	
	
	//Delete request to delete a cart item by it's id	
	@CrossOrigin
	@DeleteMapping("/cartitem/{id}")
	public ResponseEntity<CartItem> deleteCartItem(@PathVariable(value = "id") Integer id){
		return cartservice.deleteCartItem(id);
	}//End method

}//End Class
