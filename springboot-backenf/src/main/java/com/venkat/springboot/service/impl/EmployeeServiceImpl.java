package com.venkat.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.venkat.springboot.exception.ResourceNotFoundException;
import com.venkat.springboot.model.Employee;
import com.venkat.springboot.repository.EmployeeRepository;
import com.venkat.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeByID(long id) {
		Optional<Employee>  employee = employeeRepository.findById(id);
		/*if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}*/
		return employeeRepository.findById(id).orElseThrow(()-> 
					    new ResourceNotFoundException("Employee","Id",id));
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingemployee = employeeRepository.getById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Id", id));
		
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		existingemployee.setEmail(employee.getEmail());
		employeeRepository.save(existingemployee);		
				
		return existingemployee;
	}



	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(() -> 
									new ResourceNotFoundException("Employee","Id", id));
		employeeRepository.deleteById(id);
		
	}



	

	

}
