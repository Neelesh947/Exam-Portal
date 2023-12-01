package com.examPortal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examPortal.model.exam.Category;
import com.examPortal.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	//create category
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(@RequestBody  Category category)
	{
		Category category1=this.categoryService.addCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(category1);
	}
	
	//get category by id
	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId)
	{
		Category category=this.categoryService.getCategorybyID(categoryId);
		return ResponseEntity.ok(category);
				
	}
	
	
	//get all category
	@GetMapping("/")
	public ResponseEntity<Set<Category>> getAllCategory()
	{
		Set<Category> set=this.categoryService.getCategory();
		return ResponseEntity.ok(set);
	}
	
	//update category
	@PutMapping("/")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category)
	{
		Category cat=this.categoryService.updateCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body(cat);
	}
	
	//delete category
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Long categoryId)
	{
		this.categoryService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
