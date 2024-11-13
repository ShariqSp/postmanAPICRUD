package com.api.app.postman.service;

import java.util.List;

import com.api.app.postman.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);
    User updateUser(Long id, User updatedUser);
    boolean deleteUser(Long id);
    List<User> getAllUsers();
}
