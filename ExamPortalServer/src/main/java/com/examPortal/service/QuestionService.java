package com.examPortal.service;

import java.util.Set;


import com.examPortal.model.exam.Questions;
import com.examPortal.model.exam.Quiz;

public interface QuestionService {

	//add questions
	public Questions addQuestion(Questions question);
	
	//update question
	public Questions updateQuestion(Questions question);
	
	//get all Question
	public Set<Questions> getQuestion();
	
	//get single question using id
	public Questions getQuestionById(Long questionId);
	
	//delete Question
	public void deleteQuestion(Long questionId);
	
	//get list questions from the quiz
	public Set<Questions> getQuestionOfQuiz(Quiz quiz);
	
	
	public Questions get(Long questionId);
}
