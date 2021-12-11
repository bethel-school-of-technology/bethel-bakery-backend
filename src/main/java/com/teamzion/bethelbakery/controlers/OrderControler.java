package com.teamzion.bethelbakery.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PreAuthorize("hasRole('Admin')")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
		
	}//End method
	
	//Post request to add a new order
	@CrossOrigin
	@PostMapping("/order")
	@PreAuthorize("hasAnyRole('Admin', 'User')")
	public ResponseEntity<Order> addNewOrder(@RequestBody Order order){
		return orderService.addNewOrder(order);
	}//End method
	
	//Get Order by id
	@GetMapping("/order/{id}")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") int id){
		return orderService.getOrderById(id);
	}
	
}//End Class
