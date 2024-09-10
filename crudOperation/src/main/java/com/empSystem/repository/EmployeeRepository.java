package com.empSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
