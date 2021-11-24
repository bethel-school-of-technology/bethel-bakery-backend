package com.teamzion.bethelbakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamzion.bethelbakery.models.Product;

//*******************
//*ProductRepository*
//*******************

//Repository to handle CRUD function for products
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}//End interface
