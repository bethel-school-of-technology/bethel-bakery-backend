package com.teamzion.bethelbakery.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductsControler {

	@Autowired
	private ProductsRepository productsRepository;
	
	@GetMapping("/product")
	public List<Products> getAllProducts() {
		List<Products> allProducts = productsRepository.findAll();
		return allProducts;
	}
}
