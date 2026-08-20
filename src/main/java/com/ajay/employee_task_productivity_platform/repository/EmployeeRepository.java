package com.ajay.employee_task_productivity_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.employee_task_productivity_platform.entity.Employee;




@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
