package com.examPortal.service;

import java.util.List;
import java.util.Set;

import com.examPortal.model.User;
import com.examPortal.model.UserRole;

public interface UserService {

	//create User
	public User createUsers(User user, Set<UserRole> userRoles) throws Exception;

	//get all user
	public List<User> getAllUsers();

	
	//get user by username
	public User getUserByUserName(String username);
	
}
