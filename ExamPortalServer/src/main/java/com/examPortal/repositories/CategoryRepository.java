package com.examPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
