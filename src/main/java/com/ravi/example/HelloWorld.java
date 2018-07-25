package com.ravi.example;

import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class HelloWorld
{
	private String name = "SpringBoot";
	
	@Loggable
	@LogExecutionTime
	public void printHello() {
		System.out.println("Hello ! " + name);
	}
	
	@LogExecutionTime
	public Employee getEmployee(String name, int salary) {
		return new Employee(name, salary);
	}
}
