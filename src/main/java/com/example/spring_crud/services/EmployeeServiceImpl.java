package com.example.spring_crud.services;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_crud.models.Employee;
import com.example.spring_crud.repositories.EmployeeRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	@Override
	public Employee getEmployeeById(long id) {
		Employee employee =null;
		java.util.Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found");
		}
		return employee;
	}	

}
