package com.venkat.springboot.service;

import java.util.List;

import com.venkat.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	
	Employee getEmployeeByID(long id);
	List<Employee> getAllEmployees1();
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
