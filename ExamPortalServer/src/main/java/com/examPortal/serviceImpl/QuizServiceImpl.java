package com.examPortal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examPortal.model.exam.Quiz;
import com.examPortal.repositories.QuizRepository;
import com.examPortal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getListOfQuiz() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuziById(Long quizId) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(quizId).orElse(null);
	}

	@Override
	public void deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		 this.quizRepository.deleteById(quizId);
//		Quiz quiz=new Quiz();
//		quiz.setQid(quizId);
//		this.quizRepository.delete(quiz);
	}

}
