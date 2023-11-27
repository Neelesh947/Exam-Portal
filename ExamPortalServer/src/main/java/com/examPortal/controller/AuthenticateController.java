package com.examPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examPortal.config.JwtUtils;
import com.examPortal.helper.UserNotFoundException;
import com.examPortal.model.JwtRequest;
import com.examPortal.model.JwtResponse;
import com.examPortal.serviceImpl.UserDetailsSecurityServiceImpl;

@RestController
public class AuthenticateController {

	
	 @Autowired
	 private AuthenticationManager authenticationManager;

	 @Autowired
	 private UserDetailsSecurityServiceImpl userDetailsService;

	 @Autowired
	 private JwtUtils jwtUtils;
	 
	 //generate Tokens
	 
	 @PostMapping("/generate-token")
	    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

	        try {

	            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());


	        } catch (UserNotFoundException e) {
	            e.printStackTrace();
	            throw new Exception("User not found ");
	        }

	        /////////////authenticate

	        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	        String token = this.jwtUtils.generateToken(userDetails);
	        return ResponseEntity.ok(new JwtResponse(token));


	    }
	 
	 
	 private void authenticate(String username, String password) throws Exception {

	        try {

	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

	        } catch (DisabledException e) {
	            throw new Exception("USER DISABLED " + e.getMessage());
	        } catch (BadCredentialsException e) {
	            throw new Exception("Invalid Credentials " + e.getMessage());
	        }
	    }
	 

}
