package com.tron.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tron.model.Employee;

@Controller
public class EmployeeController 
{
	@GetMapping("/register")
	public String getHomePage(@ModelAttribute("emp")Employee employee)
	{
		return "register";
	}
	
	//we can have same endpoints if methods are different
	@PostMapping("/register")
	public String registerEmployee(Model model, @ModelAttribute("emp")Employee employee)
	{
		System.out.println(employee);
		model.addAttribute("emp", employee);
		return "response";
	}
}
