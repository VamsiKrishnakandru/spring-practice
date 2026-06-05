package com.tron.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tron.service.IGreetingService;

@Controller
@RequestMapping("/controller2")
public class TronController2 
{
	@Autowired
	private IGreetingService service;
	
	@GetMapping("/greet1")
	public String generateWish1(Model model)
	{
		String res = service.generateGreeting();
		model.addAttribute("wish", res + " 2nd controller response");
		return "greet";
	}
}
