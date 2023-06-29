package com.employee;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable{
	
//	2. Solve this (For lab exam practice)
//	Create Java application for emp management system
//	Requirements 
//	2.1 It should be able to store n restore emp details in a bin file using object streams
//	2.2 Emp details : id(string), first name , last name , dept(enum : RND,HR,SALES,FINANCE,PRODUCTION), 
//	joining date(LocalDate),salary
//	2.3 Let's say that : Company is only 3 years old. (so think of a validation rule on joining date)
	
	private String id;
	private String firstName;
	private String lastName;
	private Department dept;
	private LocalDate joiningDate;
	private double salary;
	
	
	public Employee(String id, String firstName, String lastName, Department dept, LocalDate joiningDate,
			double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.joiningDate = joiningDate;
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept
				+ ", joiningDate=" + joiningDate + ", salary=" + salary + "]";
	}


	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
	
	
	

}
