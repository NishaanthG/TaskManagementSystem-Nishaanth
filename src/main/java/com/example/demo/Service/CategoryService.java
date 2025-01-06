package com.example.demo.Service;

import java.util.List;
import java.util.Map;
import com.example.demo.Model.Category;

/**
 * Service interface for managing Category entities.
 * Provides methods to perform operations such as retrieval, deletion, and updating of categories.
 */
public interface CategoryService {

    /**
     * Retrieves a category by its unique ID.
     * 
     * @param CategoryId the ID of the category to retrieve.
     * @return the Category object corresponding to the provided ID.
     */
    public Category getCategoryByID(int CategoryId);

    /**
     * Retrieves all categories available in the system.
     * 
     * @return a list of all Category objects.
     */
    public List<Category> getAllCategories();

    /**
     * Deletes a category by its unique ID.
     * 
     * @param CategoryId the ID of the category to delete.
     */
    public void DeleteCategoryById(int CategoryId);

    /**
     * Updates the details of an existing category.
     * 
     * @param categoryid the ID of the category to update.
     * @param c the Category object containing updated information.
     */
    public void updateCategory(int categoryid, Category c);

    /**
     * Retrieves a map of category names and their corresponding task counts.
     * 
     * @return a map where the key is the category name and the value is the count of tasks in that category.
     */
    public Map<String, Integer> getCategorieswithTaskCounts();

}
