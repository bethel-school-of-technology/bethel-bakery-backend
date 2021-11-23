package com.teamzion.bethelbakery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.Customer;
import com.teamzion.bethelbakery.repositories.CustomerRepository;

@Service
public class CustomerService {

	//data fields
	@Autowired
	private CustomerRepository customerRepository;
	
	//methods
	public ResponseEntity<Customer> getCustomerByUserName(String userName){
		Customer foundCustomer = customerRepository.getByUserName(userName);
		if (foundCustomer == null) {
			return ResponseEntity.notFound().header("Customer", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundCustomer);
	}
	
}
