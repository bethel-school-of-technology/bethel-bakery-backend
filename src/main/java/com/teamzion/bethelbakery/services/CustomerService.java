package com.teamzion.bethelbakery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.Customer;
import com.teamzion.bethelbakery.repositories.CustomerRepository;

//*****************
//*CustomerService*
//*****************
@Service
public class CustomerService {

	//*************
	//*Data Fields*
	//*************
	@Autowired
	private CustomerRepository customerRepository;
	
	//*********
	//*methods*
	//*********
	public ResponseEntity<Customer> getCustomerByUserName(String userName){
		Customer foundCustomer = customerRepository.getByUserName(userName);
		
		if (foundCustomer == null) {
			return ResponseEntity.notFound().header("Customer", "Nothing found with that id").build();
		}//End if
		
		return ResponseEntity.ok(foundCustomer);
	}//End method
	
}//End class
