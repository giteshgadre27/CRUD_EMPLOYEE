package com.empSystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.empSystem.entity.User;

import com.empSystem.repository.UserRepository;
import com.empSystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User registerUser(User user) {
		// Encrypt password before saving
		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	/*
	 * @Override public Optional<User> loginUser(String username, String password) {
	 * User user = userRepository.findByUsername(username);
	 * 
	 * if (user != null && (password.equals(user.getPassword()))) {
	 * System.out.println(password); return Optional.of(user); } return
	 * Optional.empty();
	 * 
	 * 
	 * if (user != null && passwordEncoder.matches(password, user.getPassword())) {
	 * System.out.println(password); return Optional.of(user); } return
	 * Optional.empty();
	 * 
	 * }
	 */

	@Override
	public User loginUser(String username, String password) {
		User user = userRepository.findByUsername(username);

		if (user != null && (password.equals(user.getPassword()))) {
			//System.out.println(password);
			return user;
		}
		return null;

	}

}
