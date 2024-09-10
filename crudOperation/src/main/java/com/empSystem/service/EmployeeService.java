package com.empSystem.service;

import java.util.List;

import com.empSystem.entity.Employee;

public interface EmployeeService {
	
	 List<Employee> getAllEmployees();
	
	 Employee createNewEmployee(Employee employee);
	
	 Employee updateEmployee(Employee employee);
	
	 void deleteEmployee(long empId);
	
	 Employee getEmployeeById(int empId);

}
