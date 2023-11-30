package com.examPortal.service;

import java.util.Set;

import com.examPortal.model.exam.Category;

public interface CategoryService {

	//add category
	public Category addCategory(Category category);
	
	//update category
	public Category updateCategory(Category category);
	
	//get all category
	public Set<Category> getCategory();
	
	//get Single categories
	public Category getCategorybyID(Long categoryId);
	
	//delete category
	public void deleteCategory(Long categoryId);
	
}
