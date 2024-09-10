package com.empSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empSystem.entity.User;
import com.empSystem.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;
    
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Username already exists");
        }
    }

	
	/*
	 * @PostMapping("/login") public ResponseEntity<?> loginUser(@RequestBody User
	 * loginRequest) { return userService.loginUser(loginRequest.getUsername(),
	 * loginRequest.getPassword()) .map(user ->
	 * ResponseEntity.status(200).body("Success")) .orElseGet(() ->
	 * ResponseEntity.status(401).body("Invalid-credentials")); }
	 */
	 

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User loginRequest) {
        User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

        // Check if the user is null (authentication failed)
        if (user == null) {
            // Return 401 Unauthorized status if authentication fails
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Return the authenticated user with 200 OK status
        return ResponseEntity.ok(user);
    }

	   
    
}
