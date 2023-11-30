package com.examPortal.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.model.exam.Questions;
import com.examPortal.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Questions, Long>{

	Set<Questions> findByQuiz(Quiz quiz);		//custome finder method

}
