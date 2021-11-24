package com.teamzion.bethelbakery.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.services.ProductsService;

//******************
//*ProductControler*
//******************

//Controls the mapping of products API
@RestController
public class ProductControler {

	//*************
	//*Data Fields*
	//*************
	@Autowired
	private ProductsService service;
	
	
	//*********
	//*Methods*
	//*********
	
	//Get request to get all products
	@CrossOrigin
	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return service.getProducts();
	}//End method
	
}//End Class
