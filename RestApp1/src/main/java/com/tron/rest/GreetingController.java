package com.tron.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tron.service.IGreetingService;

@Controller
public class GreetingController 
{
	@Autowired
	private IGreetingService service;
	
	//below method is sending only response body
	//add @ResponseBody - convey this is a Rest Controller
	@GetMapping("/greet1")
	@ResponseBody
	public String getWish1()
	{
		String response = service.generateGreeting();
		return response;
	}
	
	//Recommended to send response status, headers and body
	@GetMapping("/greet2")
	@ResponseBody
	public ResponseEntity<String> getWish2()
	{
		String response = service.generateGreeting();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
