package com.example.spring_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_crud.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
