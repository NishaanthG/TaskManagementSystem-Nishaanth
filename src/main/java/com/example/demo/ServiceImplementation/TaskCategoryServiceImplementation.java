package com.example.demo.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.Model.Task;
import com.example.demo.Model.TaskCategory;
import com.example.demo.Model.TaskCategoryID;
import com.example.demo.Repository.TaskCategoryRepository;
import com.example.demo.Service.TaskCategoryService;

@Service
public class TaskCategoryServiceImplementation implements TaskCategoryService{
	
	@Autowired
	private TaskCategoryRepository tcr;
	
//	public void addTaskCategories(Task task, List<Category> categories) {
//		
//        for (Category category : categories) {
//            TaskCategoryID id = new TaskCategoryID(task.getTaskID(), category.getCategoryid());
//            if (tcr.existsById(id)) {
//                throw new PostFailsException("ADDFAILS" , "Task-Category already exist");
//            }
//            TaskCategory taskCategory = new TaskCategory(id, task, category);
//            tcr.save(taskCategory);
//        }
//    }

}
