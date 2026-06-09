package com.msedcl.main.dto;

public class EmployeeDTO {
	
	private int employeeId;
	private String name;
	private double salary;
	
	public EmployeeDTO() {
		System.out.println("Default EmployeeDTO object created and default constructor called.");
	}

	public EmployeeDTO(int employeeId, String name, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		System.out.println("Default EmployeeDTO object created and overloaded constructor called.");

	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
	}

	public int getEmployeeId() {
		System.out.println("getEmployeeId() called.");
		return employeeId;		
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		System.out.println("setEmployeeId() called.");

	}

	public String getName() {
		System.out.println("getName() called.");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName() called.");
		this.name = name;
	}

	public double getSalary() {
		System.out.println("getSalary() called.");
		return salary;
	}

	public void setSalary(double salary) {
		System.out.println("setSalary() called.");
		this.salary = salary;
	}
	
	

}
