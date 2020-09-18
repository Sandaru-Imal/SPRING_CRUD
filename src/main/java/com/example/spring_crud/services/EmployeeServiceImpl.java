package com.example.spring_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring_crud.models.Employee;
import com.example.spring_crud.repositories.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}	

}
