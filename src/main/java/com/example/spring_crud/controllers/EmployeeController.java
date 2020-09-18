package com.example.spring_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_crud.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
//	Display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}

}
