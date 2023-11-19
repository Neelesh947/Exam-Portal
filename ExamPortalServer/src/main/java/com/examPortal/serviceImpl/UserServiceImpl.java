package com.examPortal.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examPortal.model.User;
import com.examPortal.model.UserRole;
import com.examPortal.repositories.RoleRepository;
import com.examPortal.repositories.UserRepository;
import com.examPortal.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	//create user
	
	
	public User createUsers(User user, Set<UserRole> userRoles) throws Exception {
		
		User existUser=this.userRepository.findByUsername(user.getUsername());
		if(existUser != null)
		{
			System.out.println("User already present");
			throw new Exception("USER_ALREADY_PRESENT");
		}
		else
		{
			//create user
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			existUser=this.userRepository.save(user);
		}
		return existUser;
	}
	
	////get all users..................

	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}

	// get user by  user name .................................
	@Override
	public User getUserByUserName(String username) {
		
		return this.userRepository.findByUsername(username);
	}

	
}
