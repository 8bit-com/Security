package com.example.security.dao;

import com.example.security.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
    User getUserByLogin(String username);
}
