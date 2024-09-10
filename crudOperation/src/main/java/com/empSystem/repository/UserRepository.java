package com.empSystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.empSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

