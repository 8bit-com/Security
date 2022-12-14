package com.example.security.service;

import com.example.security.dao.RoleDAO;
import com.example.security.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
        addDefaultRole();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    public Role findById(long id) {
        return roleDAO.findById(id);
    }

    @Override
    public List<Role> findByIdRoles(List<Long> roles) {
        return roleDAO.findByIdRoles(roles);
    }

    @Override
    public void addDefaultRole() {
        addRole(new Role(1L,"ROLE_USER"));
        addRole(new Role(2L,"ROLE_ADMIN"));
    }
}
