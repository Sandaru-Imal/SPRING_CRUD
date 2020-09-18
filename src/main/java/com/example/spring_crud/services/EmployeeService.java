package com.example.spring_crud.services;

import java.util.*;
import org.springframework.stereotype.Component;

import com.example.spring_crud.models.Employee;
@Component
public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
}
