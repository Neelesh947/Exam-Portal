package com.examPortal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.model.exam.Category;
import com.examPortal.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

	
	public List<Quiz> findBycategory(Category cat);
	
	//user will get this data 	
	public List<Quiz> findByActive(Boolean b);
	
	//user will get this data 
	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}
