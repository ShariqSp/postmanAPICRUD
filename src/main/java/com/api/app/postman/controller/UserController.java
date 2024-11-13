package com.api.app.postman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.postman.model.User;
import com.api.app.postman.service.UserService;
	
@RestController
@RequestMapping("/api/users")
public class UserController {
	
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.loginUser(username, password);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
	
