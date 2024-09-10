package com.empSystem.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empSystem.entity.Employee;
import com.empSystem.exceptions.ResourceNotFoundException;
import com.empSystem.repository.EmployeeRepository;
import com.empSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public List<Employee> getAllEmployees() {
		// System.out.println(empDao.findAll());

		return employeeRepository.findAll();
	}

	@Override
	public Employee createNewEmployee( Employee employee) {

		return employeeRepository.save(employee);
	}

	/*
	 * @Override public Employee updateEmployee(Employee employee) { return
	 * employeeRepository.save(employee); }
	 */
	
	@Override
	public Employee updateEmployee(Employee employee) {
	 
	    return employeeRepository.save(employee);  // This will update the existing record
	}

	
	
	
	@Override
	public Employee getEmployeeById(int empId) {
		
		Employee employee=this.employeeRepository.findById((int) empId).orElseThrow(()->new ResourceNotFoundException("Employee", "EmpId",empId));
		
		return employee;
	}

	@Override
	public void deleteEmployee(long empId) {

		Employee employee = employeeRepository.findById((int) empId).orElseThrow(()->new ResourceNotFoundException("Employee", "EmpId",empId));

		employeeRepository.delete(employee);

	}

}
