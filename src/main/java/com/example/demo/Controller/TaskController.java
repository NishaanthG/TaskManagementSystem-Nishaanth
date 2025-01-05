package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService ts;
	
	@GetMapping("/api/tasks/priority/{priority}/status/{status}")
	public List<Task> getTasksbyPriorityAndStatus(@PathVariable String priority , @PathVariable String status){
		return ts.getTasksByPriorityAndStatus(priority, status);
	}
	
	@GetMapping("/api/tasks/due-soon")
	public List<Task> getTasksThatAreDueSoon(){
		return ts.getDueSoonTasks();
	}
	
	@GetMapping("/api/tasks/user/{userId}/status/{status}")
	public List<Task> getTasksByUserIDAndStatus(@PathVariable int userId , @PathVariable String status){
		return ts.getTasksByUserIDAndStatus(userId, status);
	}
	
	

	
}
