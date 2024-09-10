package com.empSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="empId")
    private int id;
	
	@Column(name="empName")
	private String name;
	
	@Column(name="empAddress")
	private String address;
	
	
	private int contactNumber;
	
	private String jobTitle;

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(int id, String name, String address, int contactNumber, String jobTitle) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.jobTitle = jobTitle;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", jobTitle=" + jobTitle + "]";
	}
	
	
	
	

}
