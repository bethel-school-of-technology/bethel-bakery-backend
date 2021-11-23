package com.teamzion.bethelbakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamzion.bethelbakery.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer getByUserName(String userName); 
}
