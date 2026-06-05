package com.tron.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TronController1 
{
	//Path Parameter
	//http://localhost:8484/queryparam/info/ram/devops
	@GetMapping("/info/{name}/{course}")
	public String displayMessage(@PathVariable("name")String name,
			@PathVariable("course")String course, Model model)
	{
		System.out.println(name+ " is in Controller");
		String response="Hello! " + name + " Welcome to Tron " + course + " Course";
		model.addAttribute("info", response);
		return "index";
	}
}
