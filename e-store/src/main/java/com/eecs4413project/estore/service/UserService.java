package com.eecs4413project.estore.service;

import com.eecs4413project.estore.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getUsersByUsername(String username);

    List<User> getUsersByEmail(String email);
}