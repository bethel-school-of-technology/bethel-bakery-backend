package com.teamzion.bethelbakery.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamzion.bethelbakery.models.Product;
import com.teamzion.bethelbakery.services.ProductsService;

@RestController
public class ProductsControler {

	//Auto creates instance of ProductsService
	@Autowired
	private ProductsService service;
	
	//Api request to get all products
	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return service.getProducts();
	}
	
	//Api request to get products by id
	@GetMapping("/product/{id}")
    public ResponseEntity<Product> getCart(@PathVariable(value="id") Integer id) {
        return service.getProduct(id);
    }
	
	//Api request to add a new products
	@PostMapping("/product")
    public ResponseEntity<Product> postCart(@RequestBody Product product) {

        return service.postProduct(product);
    }
	
	//Api request to update a product
	@PutMapping("/product/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable(value="id") Integer id, @RequestBody Product product) {
		return service.updateProduct(id, product);
	}
	
	//Api request to delete a product by id
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteCart(@PathVariable(value="id") Integer id) {
		return service.deleteProduct(id);
	}
}
