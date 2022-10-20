package com.example.security.service;

import com.example.security.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    List<Role> findByIdRoles(List<Long>roles);
    void addDefaultRole();
}
