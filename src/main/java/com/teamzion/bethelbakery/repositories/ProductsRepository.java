package com.teamzion.bethelbakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamzion.bethelbakery.models.Product;

//ProductsRepository to make the connection to SQL easier
@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>{

}
