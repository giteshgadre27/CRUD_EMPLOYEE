package com.empSystem.service;


import java.util.Optional;

import com.empSystem.entity.User;

public interface UserService {
   
	 User registerUser(User user);
	 //   Optional<User> loginUser(String username, String password);
	    User loginUser(String username, String password);
}