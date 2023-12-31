package com.examPortal.service;

import java.util.*;

import com.examPortal.model.exam.Category;
import com.examPortal.model.exam.Quiz;

public interface QuizService {

	// add quiz
	public Quiz addQuiz(Quiz quiz);
	
	//update Quiz
	public Quiz updateQuiz(Quiz quiz);
	
	//get all quiz
	public Set<Quiz> getListOfQuiz();
	
	//get quiz by id
	public Quiz getQuziById(Long quizId);
	
	//delete Quiz By id
	public void deleteQuiz(Long quizId);

	public List<Quiz> getQizzesOfCategory(Category cat);

	//get normal user quizees dor active category
	public List<Quiz> getActiveQuizzes();
	
	public List<Quiz> getActiveQuizzesOfCategory(Category c);
	
	
}
