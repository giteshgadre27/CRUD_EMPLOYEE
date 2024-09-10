package com.empSystem.exceptions;



public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4195541386731059760L;
	
	
	String resourceName;
	String fieldName;
	long fieldValue;
	String username;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public ResourceNotFoundException(String resourceName,String fieldName, String username) {
		super(String.format("%s not found with %s : %s",resourceName, fieldName,username));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.username=username;
		
	}
	
}