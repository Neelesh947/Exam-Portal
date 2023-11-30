package com.examPortal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examPortal.model.exam.Quiz;
import com.examPortal.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	// add quizes
	@PostMapping("/")
	private ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
	{
		Quiz quiz1=this.quizService.addQuiz(quiz);
		return ResponseEntity.status(HttpStatus.CREATED).body(quiz1);
		
	}
	
	//update Quiz
	@PutMapping("/")
	private ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	{
		Quiz quiz1=this.quizService.updateQuiz(quiz);
		return ResponseEntity.status(HttpStatus.OK).body(quiz1);
	}
	
	//get all quizes
	@GetMapping("/")
	private ResponseEntity<Set<Quiz>> getAllQuizesList()
	{
		Set<Quiz> set=this.quizService.getListOfQuiz();
		return ResponseEntity.ok(set);
	}
	
	//get single quiz by id
	@GetMapping("/{quizId}")
	private ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId)
	{
		Quiz quiz=this.quizService.getQuziById(quizId);
		return ResponseEntity.ok(quiz);
	}
	
	//delete Quiz by id
	@DeleteMapping("/{quizId}")
	public ResponseEntity<Void> deleteQuizById(@PathVariable Long quizId)
	{
		this.quizService.deleteQuiz(quizId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}