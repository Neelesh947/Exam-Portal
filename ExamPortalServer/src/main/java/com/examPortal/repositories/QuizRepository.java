package com.examPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
