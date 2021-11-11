package com.teamzion.bethelbakery.products;

import org.springframework.data.jpa.repository.JpaRepository;

//ProductsRepository to make the connection to SQL easier
public interface ProductsRepository extends JpaRepository<ProductsModel, Integer>{

}
