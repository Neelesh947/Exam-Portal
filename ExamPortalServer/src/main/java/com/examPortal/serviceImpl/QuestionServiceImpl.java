package com.examPortal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examPortal.model.exam.Questions;
import com.examPortal.model.exam.Quiz;
import com.examPortal.repositories.QuestionRepository;
import com.examPortal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	

	@Override
	public Questions addQuestion(Questions question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public Questions updateQuestion(Questions question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Questions> getQuestion() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Questions getQuestionById(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(questionId).orElse(null);
	}

	@Override
	public void deleteQuestion(Long questionId) {
		// TODO Auto-generated method stub
		//this.questionRepository.deleteById(questionId);
		
		Questions question=new Questions();
		question.setQuesid(questionId);
		this.questionRepository.delete(question);		
	}

	@Override
	public Set<Questions> getQuestionOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public Questions get(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepository.getOne(questionId);
	}
	
	
}
