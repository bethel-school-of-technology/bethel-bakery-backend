package com.teamzion.bethelbakery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.CartItem;
import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.repositories.CartItemRepository;
import com.teamzion.bethelbakery.repositories.ProductsRepository;

//Tells Spring that this class is a service
@Service
public class CartItemService {

	//Automates dependency injection for the CartRepository interface. 
	@Autowired
	private CartItemRepository cartRepository;
	
	@Autowired
	private ProductsRepository productRepository;
	
	//Add product to cart
	public ResponseEntity<CartItem> addProduct(Integer productId, Integer quantity) {
		//Variable decoration
		Integer addedQuantity = quantity; //The quantity of products
		Product product = productRepository.findById(productId).orElse(null); //Finds the product by its ID
		CartItem cartItem = findByProduct(productId, product); //Finds the cartItem that has the product of the product ID
		
		//If cartItem is not null, adds quantity to product that is already in cart
		if(cartItem != null && product != null) {
			addedQuantity = cartItem.getProductQuantity() + quantity;
			cartItem.setProductQuantity(addedQuantity);
			cartRepository.save(cartItem);
			return ResponseEntity.ok(cartItem);
			
		//Else If the product does not exist in cart, than adds the product to cart.
		} else if (product != null){
			cartItem = new CartItem();
			cartItem.setProductQuantity(quantity);
			cartItem.setProduct(product);
			cartRepository.save(cartItem);
			return ResponseEntity.ok(cartItem);
		}
		
		//return not found error if product not found
		else {
			return ResponseEntity.notFound().header("Product", "Nothing found with that Id").build();
		}
		
		
	}
	
	
	//TODO Total items in cart.
	//Gives total number of Items in cart
	public List<CartItem> totalItemsInCart() {
		List<CartItem> cartItemList = cartRepository.findAll();
		return cartItemList;
		
	}
	
	//Finds the cartItem by the productId
	public CartItem findByProduct(Integer productId, Product product) {
		List<CartItem> cartItems = cartRepository.findAll();
		CartItem cartItem = new CartItem();
		boolean foundItem = false;
		
		if(product != null) {
			for(int i = 0; i < cartItems.size(); i++) {
				if(cartItems.get(i).getProduct().getProductId() == product.getProductId()) {
					cartItem = cartItems.get(i);
					foundItem = true;
				}
			}
		}
		
		if(foundItem == false) {
			cartItem = null;
		}
		return cartItem;
		
	}
}
