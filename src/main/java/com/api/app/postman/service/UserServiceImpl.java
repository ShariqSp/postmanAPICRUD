package com.api.app.postman.service;

import com.api.app.postman.model.User;
import com.api.app.postman.repository.UserRepository;
import com.api.app.postman.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password) ? user : null;
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(updatedUser.getEmail());
            user.setMobile(updatedUser.getMobile());
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
