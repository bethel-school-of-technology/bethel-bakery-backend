package com.teamzion.bethelbakery.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teamzion.bethelbakery.models.Customer;
import com.teamzion.bethelbakery.services.CustomerService;

@RestController
public class CustomerControler {

	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin
	@GetMapping("/customer/{username}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable( value = "username") String userName){
		return customerService.getCustomerByUserName(userName);
	}
}
