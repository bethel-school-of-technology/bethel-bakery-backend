package com.teamzion.bethelbakery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamzion.bethelbakery.models.CartItem;
import com.teamzion.bethelbakery.models.Product;

//ProductsRepository to make the connection to SQL easier
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
//	public CartModel findByProductsModel(ProductsModel product);
	
}
