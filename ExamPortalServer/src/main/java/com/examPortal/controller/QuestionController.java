package com.examPortal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

import com.examPortal.model.exam.Questions;
import com.examPortal.model.exam.Quiz;
import com.examPortal.service.QuestionService;
import com.examPortal.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//create Questions
	@PostMapping("/")
	private ResponseEntity<Questions>  createQuestions(@RequestBody Questions questions)
	{
		Questions quest=this.questionService.addQuestion(questions);
		return ResponseEntity.status(HttpStatus.CREATED).body(quest);
	}
	
	//update questions
	@PutMapping("/")
	private ResponseEntity<Questions> updateQuestions(@RequestBody Questions questions)
	{
		Questions update=this.questionService.updateQuestion(questions);
		return ResponseEntity.status(HttpStatus.OK).body(update);
	}
	
	//get all questions of the any quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid" ) Long qid)
	{
//		Quiz quiz=new Quiz();
//		quiz.setQid(qid);		
//		Set<Questions> questionsOfQuiz=this.questionService.getQuestionOfQuiz(quiz);
//		return ResponseEntity.ok(questionsOfQuiz);
		
		Quiz quiz=this.quizService.getQuziById(qid);
		Set<Questions> questions=quiz.getQuestions();
		
		List list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
		{
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);		
	}
	
	//get all quiz question in admin
	
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid)
	{
		Quiz quiz=new Quiz();
		quiz.setQid(qid);		
		Set<Questions> questionsOfQuiz=this.questionService.getQuestionOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);
	}
	
	
	//get single question
	@GetMapping("/{questId}")
	private ResponseEntity<Questions> getSingleQuestionseUsingId(@PathVariable Long questId)
	{
		Questions ques=this.questionService.getQuestionById(questId);
		return ResponseEntity.ok(ques);
	}
	
	//get all questions
	@GetMapping("/")
	private ResponseEntity<Set<Questions>> getAllQuestions()
	{
		Set<Questions> ques=this.questionService.getQuestion();
		return ResponseEntity.ok(ques);
	}
	
	//delete Questions
	@DeleteMapping("/{questionId}")
	private ResponseEntity<Void> deleteQuestionsById(@PathVariable Long questionId)
	{
		this.questionService.deleteQuestion(questionId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//evaluate quiz/questions
	@PostMapping("/evaluate-quiz")
	private ResponseEntity<?> evaluateQuiz(@RequestBody List<Questions> questions)
	{
		System.out.println(questions);
		
		 double marksGot=0;
		 int correctAnswer=0;
		 int attempt=0;
		
		for(Questions q:questions){
			//single questions
			Questions quest=this.questionService.get(q.getQuesid());
			
			if(quest.getAnswer().equals(q.getGivenAnswer())) {
				//correct
				correctAnswer++;
				
				double markSingle=Integer.parseInt(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				marksGot += markSingle;				
			}
			
			if(q.getGivenAnswer()!=null ) {
				attempt++;
			}
			
			
		};
		
		Map<String, Object> map=Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempt",attempt);
		return ResponseEntity.ok(map);
	}
	
}
