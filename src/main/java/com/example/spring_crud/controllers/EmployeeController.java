package com.example.spring_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring_crud.models.Employee;
import com.example.spring_crud.repositories.EmployeeRepository;
import com.example.spring_crud.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServices;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewhomePage(Model model) {
        model.addAttribute("emps", employeeServices.getAllEmployees());
        return "index";
    }
    
    @RequestMapping(value = "/showNewEmployeeForm", method = RequestMethod.GET)
    public String showNewEmployeeForm(Model model ) {
//    	Create a model attribute to bind from data
    	Employee employee = new Employee();
    	model.addAttribute("emp", employee);
    	return "new_employee";
    }
    
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//    	save employee to the database
    	employeeServices.saveEmployee(employee);
    	return "redirect:/";
    }
    @RequestMapping(value = "/showFormForUpdate/{id}", method = RequestMethod.GET)
    public String showFormForUpdate(@PathVariable (value = "id")long id, Model model) {
    	Employee employee = employeeServices.getEmployeeById(id);
    	
//    	set employee as a model attribute to pre-populate the form
    	model.addAttribute("emps", employee);
    	return "update_employee";
    }
}
