package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;
import com.example.demo.Success.SuccessResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * REST Controller for managing categories.
 * Provides endpoints for CRUD operations and retrieving category-related data.
 */
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService cs;
	
	/**
     * Retrieves all categories.
     *
     * @return a list of all categories
     */
	@GetMapping("/api/categories/all")
	public List<Category> getAllCategories(){
		return cs.getAllCategories();
	}
	
	/**
     * Retrieves a specific category by its ID.
     *
     * @param categoryId the ID of the category to retrieve
     * @return the category with the given ID
     */
	@GetMapping("/api/categories/{categoryId}")
	public Category getCategorybyID(@PathVariable int categoryId) {
		return cs.getCategoryByID(categoryId);
	}

	/**
     * Deletes a specific category by its ID.
     *
     * @param categoryId the ID of the category to delete
     * @return a success response indicating the category was deleted
     */
	@DeleteMapping("/api/categories/{categoryId}")
	public ResponseEntity<SuccessResponse> deleteCategoryById(@PathVariable int categoryId){
		
		cs.DeleteCategoryById(categoryId);
		
		return ResponseEntity.ok(new SuccessResponse("DELETESUCCESS","Category deleted successfully"));
		
	}
	
	/**
     * Updates a specific category by its ID.
     *
     * @param categoryId the ID of the category to update
     * @param category   the updated category data
     * @return a success response indicating the category was updated
     */
	@PutMapping("/api/categories/update/{categoryId}")
	public ResponseEntity<SuccessResponse> UpdateCategory(@PathVariable int categoryId , @Valid @RequestBody Category c){
		cs.updateCategory(categoryId, c);
		
		return ResponseEntity.ok(new SuccessResponse("UPDATESUCCESS","Category updated Successfully"));
	}

	/**
     * Retrieves a map of category IDs and their corresponding task counts.
     *
     * @return a map where the key is the category ID and the value is the number of tasks
     */

	@GetMapping("/api/categories/task-count")
	public Map<String, Integer> getCategorieswithtaskCounts(){
		return cs.getCategorieswithTaskCounts();
	}
}
