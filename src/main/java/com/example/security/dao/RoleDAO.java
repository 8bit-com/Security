package com.example.security.dao;

import com.example.security.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    List<Role> findByIdRoles(List<Long>roles);
}
