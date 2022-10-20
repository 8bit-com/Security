package com.example.security.service;

import com.example.security.dao.UserDAO;
import com.example.security.model.Role;
import com.example.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        addDefaultUser();
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(passwordCoder(user));
    }

    @Override
    public void removeUser(long id) {
        userDAO.removeUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(passwordCoder(user));
    }

    @Override
    public User getUserByLogin(String username) {
        return userDAO.getUserByLogin(username);
    }

    @Override
    public void addDefaultUser() {
        List<Role> roleList = new ArrayList<>();
        roleList.add(roleService.findById(1L));
        List<Role> roleList2 = new ArrayList<>();
        roleList2.add(roleService.findById(1L));
        roleList2.add(roleService.findById(2L));
        User user1 = new User("Garry", "Potter", "user1@mail.ru", (byte) 27, "user1", "12345", roleList);
        User user2 = new User("Steve", "Jobs", "admin@mail.ru", (byte) 52, "admin", "admin", roleList2);
        addUser(user1);
        addUser(user2);
    }
}
