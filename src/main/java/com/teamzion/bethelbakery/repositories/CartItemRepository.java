package com.teamzion.bethelbakery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamzion.bethelbakery.models.CartItem;

import com.teamzion.bethelbakery.models.Product;

//********************
//*CartItemRepository*
//********************

//ProductsRepository for CRUD functions to database
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	
}//End interface 
