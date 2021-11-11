package com.teamzion.bethelbakery.products;

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



@RestController
public class ProductsControler {

	
	@Autowired
	private ProductsService service;
	
	@GetMapping("/product")
	public List<Products> getAllProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/product/{id}")
    public ResponseEntity<Products> getPost(@PathVariable(value="id") Integer id) {
        return service.getProduct(id);
    }
	
	@PostMapping("/product")
    public ResponseEntity<Products> postPost(@RequestBody Products product) {

        return service.postProduct(product);
    }
	
	@PutMapping("/product/{id}")
    public ResponseEntity<Products> putProduct(@PathVariable(value="id") Integer id, @RequestBody Products product) {
		return service.updateProduct(id, product);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Products> deleteUser(@PathVariable(value="id") Integer id) {
		return service.deleteProduct(id);
	}
}
