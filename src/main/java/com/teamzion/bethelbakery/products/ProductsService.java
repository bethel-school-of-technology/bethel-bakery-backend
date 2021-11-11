package com.teamzion.bethelbakery.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//This service has to implimtation of the ProductsControler
@Service
public class ProductsService {
	
	//Auto creates instance of ProductsRepository
	@Autowired
	private ProductsRepository productsRepository;
	
	//Gets all the Products from SQL
	public List<ProductsModel> getProducts() {
		List<ProductsModel> allProducts = productsRepository.findAll();
		return allProducts;
	}
	
	//Gets product by id from SQL
	public ResponseEntity<ProductsModel> getProduct(Integer id) {
        ProductsModel foundProduct = productsRepository.findById(id).orElse(null);

        if(foundProduct == null) {
            return ResponseEntity.notFound().header("Product","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundProduct);
    }
	
	//Add a new product to SQL
	public ResponseEntity<ProductsModel> postProduct(ProductsModel product) {

        // saving to DB using instance of the repo interface
       ProductsModel updatedProduct = productsRepository.save(product);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(updatedProduct);
    }
	
	//Updates a product by id in SQL
    public ResponseEntity<ProductsModel> updateProduct(Integer id, ProductsModel product) {

    	// saving to DB using instance of the repo interface
		ProductsModel foundProduct = productsRepository.findById(id).orElse(null);
        
    	if(foundProduct == null) {
    		return ResponseEntity.notFound().header("Products","Nothing found with that id").build();
    	}
    	else {
    		foundProduct.setProduct_id(id);
    		foundProduct.setName(product.getName());
    		foundProduct.setPrice(product.getPrice());
    		foundProduct.setImg_url(product.getImg_url());
    			
    		ProductsModel UpdatedProduct = productsRepository.save(foundProduct);
    		// RespEntity crafts response to include correct status codes.
    		return ResponseEntity.ok(UpdatedProduct);
    	}  
    }
    
    //Deletes the Product by SQL
    public ResponseEntity<ProductsModel> deleteProduct(Integer id) {
        ProductsModel foundProduct = productsRepository.findById(id).orElse(null);

        if(foundProduct == null) {
            return ResponseEntity.notFound().header("Product","Nothing found with that id").build();
        }else {
        	productsRepository.delete(foundProduct);
        }
        return ResponseEntity.ok().build();
    }
    
    
}
