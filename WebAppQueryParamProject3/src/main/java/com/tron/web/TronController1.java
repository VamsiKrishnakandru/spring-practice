package com.tron.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TronController1 
{
	//Query Parameter
	//http://localhost:8484/queryparam/info?name=Ram&course=devops
	//if name is not matching - instead of name we want nam in url
	//the use displayMessage(@RequestParam("nam")String name, Model model)
	@GetMapping("/info")
	public String displayMessage(String name, String course, Model model)
	{
		System.out.println(name+ " is in Controller");
		String response="Hello! " + name + " Welcome to Tron " + course + " Course";
		model.addAttribute("info", response);
		return "index";
	}
}
