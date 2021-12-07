package com.teamzion.bethelbakery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamzion.bethelbakery.models.Role;
import com.teamzion.bethelbakery.repositories.RoleDao;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
