package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Category;
import com.example.demo.Model.Task;
import com.example.demo.Model.TaskCategoryID;
import com.example.demo.Service.TaskCategoryService;
import com.example.demo.Success.SuccessResponse;

@RestController
public class TaskCategoryController {
	
	@Autowired
	private TaskCategoryService tcs;

}
