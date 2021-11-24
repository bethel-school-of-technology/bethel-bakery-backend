package com.teamzion.bethelbakery.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teamzion.bethelbakery.models.Customer;
import com.teamzion.bethelbakery.services.CustomerService;

//*******************
//*CustomerControler*
//*******************

//Controls mapping of customer API
@RestController
public class CustomerControler {

	//*************
	//*Data Fields*
	//*************
	@Autowired
	private CustomerService customerService;
	
	
	//*********
	//*Methods*
	//*********
	
	//Get request to get customer by it's user name
	@CrossOrigin
	@GetMapping("/customer/{username}")
	public ResponseEntity<Customer> getCustomerByUserName(@PathVariable( value = "username") String userName){
		return customerService.getCustomerByUserName(userName);
	}//End method

}//End Class
