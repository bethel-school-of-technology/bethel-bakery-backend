package com.teamzion.bethelbakery.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teamzion.bethelbakery.models.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
