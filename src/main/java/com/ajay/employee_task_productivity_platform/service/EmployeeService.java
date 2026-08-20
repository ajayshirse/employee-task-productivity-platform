package com.ajay.employee_task_productivity_platform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ajay.employee_task_productivity_platform.entity.Employee;
import com.ajay.employee_task_productivity_platform.repository.EmployeeRepository;



@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public  EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	
	//Add Employee
	public Employee AddEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

     //Get All Employee
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

     
	//Get Employee By Id
	public Employee getEmployeeByID(Long id) {
		
		return employeeRepository.findById(id).orElse(null);
	}

    //Update Employee
	public Employee updateEmployee(Long id ,Employee employee) {
		
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Employee Not Found"));
		
		
          existingEmployee.setName(employee.getName());
          existingEmployee.setEmail(employee.getEmail());
          existingEmployee.setDepartment(employee.getDepartment());
          existingEmployee.setDesignation(employee.getDesignation());	
          
          return employeeRepository.save(existingEmployee);
		
	}


	// Delete Employee
	public String deleteEmployee(Long id) {

		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return "Employee Deleted Successfully" ;
		}
		return "Employee Not Found" ;
	}

}
