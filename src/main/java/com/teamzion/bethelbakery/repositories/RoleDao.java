package com.teamzion.bethelbakery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teamzion.bethelbakery.models.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
