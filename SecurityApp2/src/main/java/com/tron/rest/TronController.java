package com.tron.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tron.model.Alien;
import com.tron.model.Users;
import com.tron.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TronController 
{
	@Autowired
	private UserService service;
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);
	
	@PostMapping("/add-user")
	public ResponseEntity<Users> addUser(@RequestBody Users user)
	{
		String encodedPassword = bcrypt.encode(user.getPassword());
		user.setPassword(encodedPassword);
		Users userDB = service.register(user);
		return new ResponseEntity<Users>(userDB, HttpStatus.OK);
	}
	
	@GetMapping("/course")
	public ResponseEntity<String> getCourseInfo()
	{
		String info = "Tron is launching AI course";
		return new ResponseEntity<String>(info, HttpStatus.OK);
	}
}
