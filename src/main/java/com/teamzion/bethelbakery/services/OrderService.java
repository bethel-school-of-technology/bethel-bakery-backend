package com.teamzion.bethelbakery.services;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.CartItem;
import com.teamzion.bethelbakery.models.Order;
import com.teamzion.bethelbakery.repositories.CartItemRepository;
import com.teamzion.bethelbakery.repositories.OrderRepository;

//**************
//*OrderService*
//**************

//Implementation for orders
@Service
public class OrderService {

	//*************
	//*Data Fields*
	//*************
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	
	//*********
	//*Methods*
	//*********
	
	//Get all orders
	public List<Order> getAllOrders() {
		List<Order> allOrders = orderRepository.findAll();
		return allOrders;
	}//End method
	
	//Add new order
	public ResponseEntity<Order> addNewOrder(Order order){
		addAllCartItems(order.getCartItems());
		order.setDateTimeStamp(calculateCurrentDate());
		Order newOrder = orderRepository.save(order);
		return ResponseEntity.ok(newOrder);
		
	}//End method

	public void addAllCartItems(List<CartItem> cartItems) {
		
		for(int i = 0; i < cartItems.size() ; i++) {
			cartItemRepository.save(cartItems.get(i));
		}
		
	}
	
	public String calculateCurrentDate() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a MM/dd/yyyy z");
		
		return dateFormat.format(currentDate);
	}
	
	//Get Order by id
	public ResponseEntity<Order> getOrderById(int id){
		Order newOrder = orderRepository.findById(id).orElse(null);
		
		if(newOrder == null) {
			return ResponseEntity.notFound().header("Order", "Nothing found with that Id").build();
		}
		return ResponseEntity.ok(newOrder);
	}
}//End Class
