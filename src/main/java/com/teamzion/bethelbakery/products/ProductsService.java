package com.teamzion.bethelbakery.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Products> getProducts() {
		List<Products> allProducts = productsRepository.findAll();
		return allProducts;
	}
	
	public ResponseEntity<Products> getProduct(Integer id) {
        Products foundProduct = productsRepository.findById(id).orElse(null);

        if(foundProduct == null) {
            return ResponseEntity.notFound().header("Product","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundProduct);
    }
	
	public ResponseEntity<Products> postProduct(Products product) {

        // saving to DB using instance of the repo interface
       Products updatedProduct = productsRepository.save(product);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(updatedProduct);
    }
	
    public ResponseEntity<Products> updateProduct(Integer id, Products product) {

    	// saving to DB using instance of the repo interface
		Products foundProduct = productsRepository.findById(id).orElse(null);
        
    	if(foundProduct == null) {
    		return ResponseEntity.notFound().header("Products","Nothing found with that id").build();
    	}
    	else {
    		foundProduct.setProduct_id(id);
    		foundProduct.setName(product.getName());
    		foundProduct.setPrice(product.getPrice());
    		foundProduct.setImg_url(product.getImg_url());
    			
    		Products UpdatedProduct = productsRepository.save(foundProduct);
    		// RespEntity crafts response to include correct status codes.
    		return ResponseEntity.ok(UpdatedProduct);
    	}  
    }
    
    public ResponseEntity<Products> deleteProduct(Integer id) {
        Products foundProduct = productsRepository.findById(id).orElse(null);

        if(foundProduct == null) {
            return ResponseEntity.notFound().header("Product","Nothing found with that id").build();
        }else {
        	productsRepository.delete(foundProduct);
        }
        return ResponseEntity.ok().build();
    }
    
    
}
