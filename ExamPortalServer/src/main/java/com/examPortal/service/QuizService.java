package com.examPortal.service;

import java.util.Set;

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
	
}
