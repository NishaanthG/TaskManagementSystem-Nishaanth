package com.example.demo.ControllerTesting;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;
import com.example.demo.Controller.CategoryController;
import com.example.demo.Exception.*;
import com.example.demo.Success.SuccessResponse;
import com.example.demo.GlobalExceptionHandler.CategoryGlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTesting {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new CategoryGlobalExceptionHandler()) // Global exception handler
                .build();
    }
    
    @Test
    @DisplayName("Test for fetching all categories - Positive")
    void testGetAllCategories() throws Exception {
        Category category1 = new Category();
        category1.setCategoryID(1);
        category1.setCategoryName("Category1");
        Category category2 = new Category();
        category2.setCategoryID(2);
        category2.setCategoryName("Category2");
        
        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(category1, category2));

        mockMvc.perform(get("/api/categories/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].categoryName").value("Category1"))
                .andExpect(jsonPath("$[1].categoryName").value("Category2"));
    }

    @Test
    @DisplayName("Test for fetching all categories - Negative (Empty list)")
    void testGetAllCategoriesEmptyList() throws Exception {
        when(categoryService.getAllCategories()).thenThrow(new CategoryListEmptyException("GETFAILS", "Category list is empty"));

        mockMvc.perform(get("/api/categories/all"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("GETFAILS"))
                .andExpect(jsonPath("$.message").value("Category list is empty"));
    }

    @Test
    @DisplayName("Test for fetching category by ID - Positive")
    void testGetCategoryById() throws Exception {
        Category category = new Category();
        category.setCategoryID(1);
        category.setCategoryName("Category 1");
        when(categoryService.getCategoryByID(1)).thenReturn(category);

        mockMvc.perform(get("/api/categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryName").value("Category 1"));
    }

    @Test
    @DisplayName("Test for fetching category by ID - Negative (Category not found)")
    void testGetCategoryByIdNotFound() throws Exception {
        when(categoryService.getCategoryByID(1)).thenThrow(new categoryObjectNotFoundException("GETFAILS", "Category doesn't exist"));

        mockMvc.perform(get("/api/categories/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("GETFAILS"))
                .andExpect(jsonPath("$.message").value("Category doesn't exist"));
    }

    @Test
    @DisplayName("Test for deleting category by ID - Positive")
    void testDeleteCategoryById() throws Exception {
        doNothing().when(categoryService).DeleteCategoryById(1);

        mockMvc.perform(delete("/api/categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("DELETESUCCESS"))
                .andExpect(jsonPath("$.message").value("Category deleted successfully"));
    }

    @Test
    @DisplayName("Test for deleting category by ID - Negative (Category not found)")
    void testDeleteCategoryByIdNotFound() throws Exception {
        doThrow(new DeleteCategoryFailsException("DLTFAILS", "Category doesn't Exist")).when(categoryService).DeleteCategoryById(1);

        mockMvc.perform(delete("/api/categories/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("DLTFAILS"))
                .andExpect(jsonPath("$.message").value("Category doesn't Exist"));
    }

    @Test
    @DisplayName("Test for updating category - Positive")
    void testUpdateCategory() throws Exception {
  
        doNothing().when(categoryService).updateCategory(eq(1), any(Category.class));
     
        mockMvc.perform(put("/api/categories/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"categoryName\":\"Updated Category\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("UPDATESUCCESS"))
                .andExpect(jsonPath("$.message").value("Category updated Successfully"));
    }

    @Test
    @DisplayName("Test for updating category - Negative (Category not found)")
    void testUpdateCategoryNotFound() throws Exception {
        doThrow(new UpdateCategoryFailsException("UPDTFAILS", "Category doesn't exist")).when(categoryService).updateCategory(eq(1), any(Category.class));

        mockMvc.perform(put("/api/categories/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"categoryName\":\"Updated Category\"}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("UPDTFAILS"))
                .andExpect(jsonPath("$.message").value("Category doesn't exist"));
    }

    @Test
    @DisplayName("Test for fetching categories with task counts - Positive")
    void testGetCategoriesWithTaskCounts() throws Exception {
        Map<String, Integer> taskCounts = new HashMap<>();
        taskCounts.put("Front-end", 5);
        taskCounts.put("Back-End", 3);

        when(categoryService.getCategorieswithTaskCounts()).thenReturn(taskCounts);

        mockMvc.perform(get("/api/categories/task-count"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.1").value(5))
//                .andExpect(jsonPath("$.2").value(3));
    }

    @Test
    @DisplayName("Test for fetching categories with task counts - Negative (Empty list)")
    void testGetCategoriesWithTaskCountsEmptyList() throws Exception {
        when(categoryService.getCategorieswithTaskCounts()).thenThrow(new CategoryWithTaskCountListEmptyException("GETFAILS", "Category List is empty"));

        mockMvc.perform(get("/api/categories/task-count"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("GETFAILS"))
                .andExpect(jsonPath("$.message").value("Category List is empty"));
    }
}
