package com.ajay.employee_task_productivity_platform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ajay.employee_task_productivity_platform.entity.Task;
import com.ajay.employee_task_productivity_platform.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	// Add Task
	public Task AddTask(Task task) {
		return taskRepository.save(task);
	}

	// Get All Task
	public List<Task> getAllTask() {

		return taskRepository.findAll();
	}

	// Get Task By Id
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	//update task 
	public Task updateTask(Long id, Task task) {
		Task existingTask =taskRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Task Not Found"));
		
		existingTask.setTitle(task.getTitle());
		existingTask.setStatus(task.getStatus());
		existingTask.setPriority(task.getPriority());
		existingTask.setdueDate(task.getdueDate());
		existingTask.setDescription(task.getDescription());
		existingTask.setEmployeeId(task.getEmployeeId());
		
		return taskRepository.save(existingTask);
	}
    
	//Delete Task
	public String deleteTask(Long id) {
		if (taskRepository.existsById(id)) {
			taskRepository.deleteById(id);
			return "Task Deleted Successfully";
		}
		return "Task Not Found";
	}
	
	

}
