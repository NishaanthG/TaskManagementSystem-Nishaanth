package com.example.demo.ServiceImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.CategoryListEmptyException;
import com.example.demo.Exception.CategoryWithTaskCountListEmptyException;
import com.example.demo.Exception.DeleteCategoryFailsException;
import com.example.demo.Exception.UpdateCategoryFailsException;
import com.example.demo.Exception.categoryObjectNotFoundException;
import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Service.CategoryService;

/**
 * Implementation of the {@link CategoryService} interface.
 * Handles business logic for managing categories.
 */
@Service
public class CategoryServiceImplementation implements CategoryService {
	
	@Autowired
	private CategoryRepository cr;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImplementation.class);

	/**
     * Retrieves a category by its ID.
     *
     * @param CategoryId the ID of the category to retrieve
     * @return the {@link Category} if found
     * @throws GetFailsException if the category doesn't exist
     */
	@Override
	public Category getCategoryByID(int CategoryId) 
	{
		logger.info("Fetching category by ID : {}" , CategoryId);
		
		Optional<Category> c = cr.findById(CategoryId);
		
		if (c.isPresent()) {
			logger.info("Category found: {}", c.get().getCategoryName());
			Category c1 = c.get();
			return c1;
		}
		else {
			logger.error("Category with ID {} does not exist", CategoryId);
			throw new categoryObjectNotFoundException("GETFAILS", "Category doesn't exist");
		}
	}

	 /**
     * Retrieves all categories.
     *
     * @return a list of all categories
     * @throws GetFailsException if no categories are found
     */
	@Override
	public List<Category> getAllCategories() {
		logger.info("Fetching all categories");
		
		List<Category> lc = cr.findAll();
		
		if (lc.isEmpty()) {
			logger.error("Category list is empty");
			throw new CategoryListEmptyException("GETFAILS", "Category list is empty");
		}
		else {
			logger.info("Total categories found: {}", lc.size());
			return lc;
		}
	}

	/**
     * Deletes a category by its ID.
     *
     * @param CategoryId the ID of the category to delete
     * @throws DeleteFailsException if the category doesn't exist
     */
	@Override
	public void DeleteCategoryById(int CategoryId) {
		logger.info("Deleting category with ID : {}" , CategoryId);
		
		Optional<Category> oc = cr.findById(CategoryId);
		
		if (oc.isEmpty()) {
			logger.error("Category with ID {} does not exist", CategoryId);
			throw new DeleteCategoryFailsException("DLTFAILS","Category doesn't Exist");
		}
		else {
			Category c = oc.get();
			cr.delete(c);
			logger.info("Category with ID {} deleted successfully", CategoryId);
		}
	}
	
	/**
     * Updates a category by its ID.
     *
     * @param categoryid the ID of the category to update
     * @param c          the updated {@link Category} object
     * @throws UpdateFailsException if the category doesn't exist
     */
	public void updateCategory(int categoryid , Category c) {
		logger.info("Updating category with ID: {}", categoryid);
		
		Optional<Category> oc = cr.findById(categoryid);
		
		if(oc.isEmpty()) {
			logger.error("Category with ID {} does not exist", categoryid);
			throw new UpdateCategoryFailsException("UPDTFAILS","Category doesn't exist");
		}
		else {
			Category c1 = oc.get();
			if(c.getCategoryName()!=null) {
				c1.setCategoryName(c.getCategoryName());
				cr.save(c1);
				logger.info("Category with ID {} updated successfully", categoryid);
			}
		}
	}
	
	 /**
     * Retrieves a map of category IDs to the count of tasks associated with each category.
     *
     * @return a map where the key is the category ID, and the value is the task count
     */
	public Map<String , Integer> getCategorieswithTaskCounts() {
		logger.info("Fetching categories with task counts");
		
		List<Category> lc = cr.findAll();
		
		Map<String , Integer> map  = new HashMap<>(); 
		
		for(Category c : lc) {
			map.put(c.getCategoryName(), c.getTaskCategories().size());
		}
		
		if(map.isEmpty()) {
			throw new CategoryWithTaskCountListEmptyException("GETFAILS" , "Category List is empty");
		}
		logger.info("Categories with task counts: {}", map);
		return map;
		
	}
}
