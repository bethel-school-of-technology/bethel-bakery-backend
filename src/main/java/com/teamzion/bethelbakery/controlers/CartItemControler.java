package com.teamzion.bethelbakery.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamzion.bethelbakery.models.CartItem;
import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.services.CartItemService;
import com.teamzion.bethelbakery.services.ProductsService;

@RestController
public class CartItemControler {
		
		//Auto creates instance of CartService
		@Autowired
		private CartItemService cartservice;
		
		//Adds Item to Cart
		@PostMapping("cart/add/{pid}/{qty}")
		public ResponseEntity<CartItem> addProductToCart(@PathVariable(value = "pid") Integer productId, 
				@PathVariable(value = "qty") Integer quantity) {
			
			return cartservice.addProduct(productId, quantity);
			
		}
		
		//TODO Give Total amount of Items in cart.
		//Gives Total amount of Items in cart
		@GetMapping("cart/totalincart")
		public Integer totalInCart() {
			return  cartservice.totalItemsInCart();
		}
}
