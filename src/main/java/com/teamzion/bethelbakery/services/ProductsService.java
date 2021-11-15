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
	
	//Gets product by id from SQL
	public ResponseEntity<Product> getProduct(Integer id) {
        Product foundProduct = productsRepository.findById(id).orElse(null);

        if(foundProduct == null) {
            return ResponseEntity.notFound().header("Product","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundProduct);
    }
	
	//Add a new product to SQL
	public ResponseEntity<Product> postProduct(Product product) {

        // saving to DB using instance of the repo interface
       Product updatedProduct = productsRepository.save(product);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(updatedProduct);
    }
	
	//Updates a product by id in SQL
    public ResponseEntity<Product> updateProduct(Integer id, Product product) {

    	// saving to DB using instance of the repo interface
		Product foundProduct = productsRepository.findById(id).orElse(null);
        
    	if(foundProduct == null) {
    		return ResponseEntity.notFound().header("Products","Nothing found with that id").build();
    	}
    	else {
    		foundProduct.setProductId(id);
    		foundProduct.setName(product.getName());
    		foundProduct.setPrice(product.getPrice());
    		foundProduct.setImgUrl(product.getImgUrl());
    			
    		Product UpdatedProduct = productsRepository.save(foundProduct);
    		// RespEntity crafts response to include correct status codes.
    		return ResponseEntity.ok(UpdatedProduct);
    	}  
    }
    
    //Deletes the Product by SQL
    public ResponseEntity<Product> deleteProduct(Integer id) {
        Product foundProduct = productsRepository.findById(id).orElse(null);

        if(foundProduct == null) {
            return ResponseEntity.notFound().header("Product","Nothing found with that id").build();
        }else {
        	productsRepository.delete(foundProduct);
        }
        return ResponseEntity.ok().build();
    }
    
    
}
