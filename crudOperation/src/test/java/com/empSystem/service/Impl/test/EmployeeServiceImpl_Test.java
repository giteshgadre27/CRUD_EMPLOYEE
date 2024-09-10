package com.empSystem.service.Impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.empSystem.entity.Employee;
import com.empSystem.exceptions.ResourceNotFoundException;
import com.empSystem.repository.EmployeeRepository;
import com.empSystem.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImpl_Test {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Mock
	private EmployeeRepository employeeRepository;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	
	  @Test 
	  void getEmployeeByIdTest_Success() {
	 	  
	  // Arrange 
	  int empId = 10; 
		  
	  Employee mockEmployee = new Employee(10,"Amol Garg","Gujrat",1234567890,"Scrum Master"); //expect result
		 
	  when(employeeRepository.findById(empId)).thenReturn(Optional.of(mockEmployee));
		  //actual result
		  Employee result = employeeServiceImpl.getEmployeeById(empId);
	
	   //assertEquals(expected, actual);
	      assertEquals(mockEmployee.getId(), result.getId());
		  assertEquals(mockEmployee.getName(), result.getName());
		  
	  }
	 
	  
	  @Test
	  void getEmployeeById_NotFound() {
	      // Arrange
	      int empId = 9;
	    
	      // Mock the repository to return an empty Optional when findById is called with empId
	      when(employeeRepository.findById(empId)).thenReturn(Optional.empty());
	      
      
	   // Assert and Act
	      assertThrows(ResourceNotFoundException.class, () -> employeeServiceImpl.getEmployeeById(empId));
	  }
	  
	  
	  
	  
	  
	  



}
