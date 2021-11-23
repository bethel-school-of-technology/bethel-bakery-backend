package com.teamzion.bethelbakery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.repositories.ProductsRepository;

//This service has to implimtation of the ProductsControler
@Service
public class ProductsService {
	
	//Auto creates instance of ProductsRepository
	@Autowired
	private ProductsRepository productsRepository;
	
	//Gets all the Products from SQL
	public List<Product> getProducts() {
		List<Product> allProducts = productsRepository.findAll();
		return allProducts;
	}
    
}
