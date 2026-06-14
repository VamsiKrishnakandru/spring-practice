package com.tron.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tron.model.Users;
import com.tron.service.UserService;

@RestController
public class TronController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);
	
	@PostMapping("/add-user")
	public ResponseEntity<Users> addUser(@RequestBody Users user)
	{
		String encodedPassword = bcrypt.encode(user.getPassword());
		user.setPassword(encodedPassword);
		Users userDB = service.register(user);
		return new ResponseEntity<Users>(userDB, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Users user)
	{
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(
				user.getName(), user.getPassword()));
		if(auth.isAuthenticated())
		{
			String jwt = jwtService.generateToken(user.getName());
			return new ResponseEntity<String>(jwt, HttpStatus.OK);
		}
		else 
		{
			String jwt = "Invalid user and password";
			return new ResponseEntity<String>(jwt, HttpStatus.OK);
		}
	}
	
	@GetMapping("/course")
	public ResponseEntity<String> getCourseInfo()
	{
		String info = "Tron is launching AI course";
		return new ResponseEntity<String>(info, HttpStatus.OK);
	}
}
