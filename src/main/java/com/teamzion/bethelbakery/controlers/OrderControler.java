package com.teamzion.bethelbakery.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamzion.bethelbakery.models.Order;
import com.teamzion.bethelbakery.services.OrderService;

//****************
//*OrderControler*
//****************

//Controls mapping of order API
@RestController
public class OrderControler {

	//*************
	//*Data Fields*
	//*************
	@Autowired
	private OrderService orderService;
	
	//*********
	//*Methods*
	//*********

	//Get request to get all of the orders 
	@CrossOrigin
	@GetMapping("/order")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
		
	}//End method
	
	//Post request to add a new order
	@CrossOrigin
	@PostMapping("/order")
	public ResponseEntity<Order> addNewOrder(@RequestBody Order order){
		return orderService.addNewOrder(order);
	}//End method
	
}//End Class
