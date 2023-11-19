package com.examPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
