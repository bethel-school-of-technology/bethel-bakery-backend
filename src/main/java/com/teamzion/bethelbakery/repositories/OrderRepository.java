package com.teamzion.bethelbakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamzion.bethelbakery.models.Order;

//*****************
//*OrderRepository*
//*****************

//Repository to handle CRUD function for orders
public interface OrderRepository extends JpaRepository<Order, Integer> {

}//End interface
