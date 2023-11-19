package com.examPortal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examPortal.model.Role;
import com.examPortal.model.User;
import com.examPortal.model.UserRole;
import com.examPortal.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//creating user
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception
	{
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(45L);
		role.setRolename("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		User user1=this.userService.createUsers(user, roles );
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	
	//get all user
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers()
	{
		
		List<User> user=this.userService.getAllUsers();
		return ResponseEntity.ok(user);
	}
	
	//find user by username.............................
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable ("username")  String username)
	{
		User user=this.userService.getUserByUserName(username);
		
		return ResponseEntity.ok(user);
	}
}
