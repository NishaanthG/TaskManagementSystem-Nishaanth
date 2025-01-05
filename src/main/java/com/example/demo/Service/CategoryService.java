package com.example.demo.Service;

import java.util.List;
import java.util.Map;
import com.example.demo.Model.Category;

public interface CategoryService {
	
	public Category getCategoryByID(int CategoryId);
	
	public List<Category> getAllCategories();
	
	public void DeleteCategoryById(int CategoryId);
	
	public void updateCategory(int categoryid , Category c);
	
	public Map<String, Integer> getCategorieswithTaskCounts();
 
}
