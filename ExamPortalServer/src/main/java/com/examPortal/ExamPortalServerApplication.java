package com.examPortal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.examPortal.model.Role;
import com.examPortal.model.User;
import com.examPortal.model.UserRole;
import com.examPortal.service.UserService;

@SpringBootApplication
public class ExamPortalServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// System.out.println("program started");

//		
//		  User user=new User();
//		  
//		  user.setFirstname("Neelesh"); 
//		  user.setLastname("Kumar");
//		  user.setUsername("neeleshkumarm98");
//		  user.setEmail("neeleshkumarm98@gmail.com"); 
//		  user.setPassword(this.passwordEncoder.encode("Neelesh@123"));
//		  user.setPhone("9471458227"); user.setImage("default.png");
//		  
//		  
//		  Role role1=new Role(); role1.setRoleId(44L); role1.setRolename("ADMIN");
//		  
//		  Set<UserRole> userRoleSet= new HashSet<>(); UserRole userRole=new UserRole();
//		  userRole.setRole(role1); userRole.setUser(user);
//		  
//		  userRoleSet.add(userRole);
//		  
//		  User user1=this.userService.createUsers(user, userRoleSet);
//		  System.out.println(user1);
		 
	}

}
