package com.ravi.example;

public class Employee {

	String name;
	int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Name: "+ name + " Salary: "+salary;
	}

}
