package com.ajay.employee_task_productivity_platform.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.employee_task_productivity_platform.entity.Employee;
import com.ajay.employee_task_productivity_platform.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Add Employee
	@PostMapping
	public Employee AddEmployee(@RequestBody Employee employee) {
		return employeeService.AddEmployee(employee);
	}

	// Get All Employee
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	//Get Employee By Id
    @GetMapping("/{id}")
	public Employee getEmployeeByID(@PathVariable Long id) {
	   return employeeService.getEmployeeByID(id);	
	}
	
    //Update Employee
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id ,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id ,employee);
	}
	
	//Delete employee
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
		
	}
}
