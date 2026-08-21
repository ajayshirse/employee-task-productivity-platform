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

import com.ajay.employee_task_productivity_platform.entity.Task;
import com.ajay.employee_task_productivity_platform.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService; 
	}
	
	
	//Add Task 
	@PostMapping
	public Task AddTask(@RequestBody Task task) {
		return taskService.AddTask(task);
	}
	
	//Get All Task 
	@GetMapping
	public List<Task> getAllTask(){
		return taskService.getAllTask();
	}
	
	//Get Task By ID
    @GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	
    //Update Task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id ,@RequestBody Task task) {
    	return taskService.updateTask(id , task);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id ) {
    	return taskService.deleteTask(id);
    }
    
}
