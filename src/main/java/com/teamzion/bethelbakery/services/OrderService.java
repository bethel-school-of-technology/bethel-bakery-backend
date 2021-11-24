package com.teamzion.bethelbakery.services;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.Order;
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
		Order newOrder = orderRepository.save(order);
		return ResponseEntity.ok(newOrder);
	}//End method

}//End Class
