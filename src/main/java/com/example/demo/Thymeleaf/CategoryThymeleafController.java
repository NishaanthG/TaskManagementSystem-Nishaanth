package com.example.demo.Thymeleaf;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Thymeleaf Controller for managing categories.
 */
@Controller
@RequestMapping("/categories")
public class CategoryThymeleafController {

    @Autowired
    private CategoryService categoryService;
    
    /**
     * Displays all categories.
     *
     * @param model the model to pass data to the view
     * @return the HTML template for displaying all categories
     */
    @GetMapping("/all")
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    /**
     * Displays a specific category by its ID.
     *
     * @param categoryId the ID of the category to retrieve
     * @param model      the model to pass data to the view
     * @return the HTML template for displaying a single category
     */
    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") int categoryId, Model model) {
        Category category = categoryService.getCategoryByID(categoryId);
        model.addAttribute("category", category);
        return "category-details";
    }

    /**
     * Deletes a category by its ID and redirects to the categories page.
     *
     * @param categoryId the ID of the category to delete
     * @return a redirect to the categories page
     */
    @GetMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") int categoryId) {
        categoryService.DeleteCategoryById(categoryId);
        return "redirect:/categories/all";
    }

    /**
     * Displays the form to update a category.
     *
     * @param categoryId the ID of the category to update
     * @param model      the model to pass data to the view
     * @return the HTML template for updating a category
     */
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") int categoryId, Model model) {
        Category category = categoryService.getCategoryByID(categoryId);
        model.addAttribute("category", category);
        return "edit-category";
    }

    /**
     * Processes the update for a category.
     *
     * @param categoryId the ID of the category to update
     * @param category   the updated category data
     * @return a redirect to the categories page
     */
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") int categoryId, @ModelAttribute Category category) {
        categoryService.updateCategory(categoryId, category);
        return "redirect:/categories/all";
    }

    /**
     * Displays the form to add a new category.
     *
     * @param model the model to pass data to the view
     * @return the HTML template for adding a new category
     */
    @GetMapping("/new")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "add-category";
    }

    /**
     * Processes the creation of a new category.
     *
     * @param category the new category data
     * @return a redirect to the categories page
     */
    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.updateCategory(0, category); // 0 or custom logic for adding a new category
        return "redirect:/categories/all";
    }

    /**
     * Displays categories with task counts.
     *
     * @param model the model to pass data to the view
     * @return the HTML template for displaying task counts
     */
    @GetMapping("/task-count")
    public String getCategoriesWithTaskCounts(Model model) {
        Map<String, Integer> taskCounts = categoryService.getCategorieswithTaskCounts();
        model.addAttribute("taskCounts", taskCounts);
        return "category-task-count";
    }
}