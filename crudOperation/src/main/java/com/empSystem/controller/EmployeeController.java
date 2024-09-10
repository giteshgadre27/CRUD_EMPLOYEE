package com.empSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empSystem.entity.Employee;
import com.empSystem.exceptions.ApiResponse;
import com.empSystem.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*") 
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployee(){
		return this.employeeService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public Employee addEmp(@RequestBody Employee employee) {
		return this.employeeService.createNewEmployee(employee);
	}
	
	/*
	 * @PutMapping("/employees") public Employee updateEmp(@RequestBody Employee
	 * employee) { return this.employeeService.updateEmployee(employee); }
	 */
	
	@PutMapping("/employees/{id}")
	public Employee updateEmp(@PathVariable int id, @RequestBody Employee employee) {
	    employee.setId(id);  // Ensure the ID is set on the Employee object
	    return this.employeeService.updateEmployee(employee);
	}

	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<ApiResponse> deleteEmp(@PathVariable int empId) {
		this.employeeService.deleteEmployee(empId);
		return new ResponseEntity<ApiResponse> (new ApiResponse("employee Deleted Successfully",true),HttpStatus.OK);
	
		
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmpById(@PathVariable int empId) {
			
		return 	this.employeeService.getEmployeeById(empId);
	}
	

}
