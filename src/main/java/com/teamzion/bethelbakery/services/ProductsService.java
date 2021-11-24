package com.teamzion.bethelbakery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.repositories.ProductRepository;
//*****************
//*ProductsService*
//*****************

//Implementation for products
@Service
public class ProductsService {
	
	//*************
	//*Data Fields*
	//*************
	
	@Autowired
	private ProductRepository productsRepository;
	
	
	//*********
	//*Methods*
	//*********
	
	//Gets all the Products 
	public List<Product> getProducts() {
		List<Product> allProducts = productsRepository.findAll();
		return allProducts;
	}//End method
    
}//End Class
