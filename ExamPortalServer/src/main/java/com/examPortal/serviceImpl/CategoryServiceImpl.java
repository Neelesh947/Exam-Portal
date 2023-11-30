package com.examPortal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examPortal.model.exam.Category;
import com.examPortal.repositories.CategoryRepository;
import com.examPortal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategory() {
		// TODO Auto-generated method stub
		
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategorybyID(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).orElse(null);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		//this.categoryRepository.deleteById(categoryId);		
		
		Category category=new Category();
		category.setCid(categoryId);
		this.categoryRepository.delete(category);
	}

}
