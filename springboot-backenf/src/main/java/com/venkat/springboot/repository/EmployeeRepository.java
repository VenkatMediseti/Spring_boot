package com.venkat.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.springboot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
