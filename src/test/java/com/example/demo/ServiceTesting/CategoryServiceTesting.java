package com.example.demo.ServiceTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Exception.CategoryListEmptyException;
import com.example.demo.Exception.DeleteCategoryFailsException;
import com.example.demo.Exception.UpdateCategoryFailsException;
import com.example.demo.Exception.categoryObjectNotFoundException;
import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;

import jakarta.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceTesting {
	
	@Autowired
	private CategoryService cs;
	
	@Test
	@DisplayName("Test For Getting all Categories - Positive")
	public void testgetallCategories_Positive() {
		List<Category> ls = cs.getAllCategories();
		assertFalse(ls.isEmpty());
	}
	
	@Test
	@DisplayName("Test For getting all Categories - Negative")
	public void testGetAllCategories_Negative() {
		
		 assertThrows(CategoryListEmptyException.class, () -> {
		 List<Category> emptyList = cs.getAllCategories();
		 assertFalse(emptyList.isEmpty());
		 });
	}
	
	@Test
	@DisplayName("Test for Getting specific Category by Id - Positive")
	public void tesTGetSpecificCategory_Positive() {
		int categoryid = 4;
		Category c = cs.getCategoryByID(categoryid);
		assertEquals(categoryid, c.getCategoryID());
	}
	
	@Test
	@DisplayName("Test for Getting Specifc Category by Id - Negative")
	public void testGetSpecificCategory_Negative() {
		int invalidCategory = 9999;
		assertThrows(categoryObjectNotFoundException.class, () -> cs.getCategoryByID(invalidCategory));
	}
	
	@Test
	@DisplayName("Test For deleting a Category - Positive")
	public void testDeleteCategoryById_Positive() {
		int length = cs.getAllCategories().size();
		
		cs.DeleteCategoryById(2);
		assertEquals(length - 1, cs.getAllCategories().size());
	}
	
	 @Test
	 @DisplayName("Test For Deleting a Category - Negative")
	 public void testDeleteCategoryById_Negative() {
	     int invalidCategoryId = 9999;
	     assertThrows(DeleteCategoryFailsException.class, () -> cs.DeleteCategoryById(invalidCategoryId));
	 }
	
	@Test
	@DisplayName("Test For Update Category - Positive")
	public void testUpdateCategory_Positive() {
		
		int categoryid = 4;
		Category c = new Category("Cloud Migration", null);
		cs.updateCategory(categoryid, c);
		
		assertEquals(cs.getCategoryByID(categoryid).getCategoryName(), "Cloud Migration");
	}
	
	 @Test
	 @DisplayName("Test For Updating a Category - Negative")
	 public void testUpdateCategory_Negative() {
	    int invalidCategoryId = 9999;
	    Category c = new Category("Invalid Update", null);
	    assertThrows(UpdateCategoryFailsException.class, () -> cs.updateCategory(invalidCategoryId, c));
	 }
	
	 @Test
	 @DisplayName("Test For Getting Categories with Task Counts - Positive") 
	 @Transactional
	 public void testForGetCategorieswithTaskCount() {
		Map<String , Integer> map = cs.getCategorieswithTaskCounts() ;
		
		assertFalse(map.isEmpty());
	 }
	 
	 @Test
	 @DisplayName("Test For Getting Categories with Task Counts - Negative")
	 @Transactional
	 public void testGetCategoriesWithTaskCounts_Negative() {
	     Map<String, Integer> map = cs.getCategorieswithTaskCounts();
	     assertFalse(map.isEmpty());
	 }

}
	 
