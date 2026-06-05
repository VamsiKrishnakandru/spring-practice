package com.tron.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tron.service.IGreetingService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
//class level mapping is added below and it is used based on requirement
//@RequestMapping("/controller1")
public class GreetingController 
{
	@Autowired
	private IGreetingService service;
	
	//by default method is GET
	//@RequestMapping(value="/greet", method=RequestMethod.GET)
	@GetMapping("/greeting") 
	public String generateWish1(Model model)
	{
		String res = service.generateGreeting();
		model.addAttribute("wish", res);
		return "greet";
	}
	
	@GetMapping("/greet2")
	//using "Model" below will make app more invasive i.e., tightly bonded with a particular framework
	//since "Model" is child of "Map", map is loose coupled and non invasive 
	public String generateWish(Map<String, Object> map)
	{
		String res=service.generateGreeting();
		map.put("wish", res + " map");
		return "greet";
	}
	
	//below we are not setting logical view name with setViewName or returning the view
	//Then spring will look for logical view name from the endpoint
	//Should have logical view name = endpoint
	//To below code we cannot have class level mapping
	@GetMapping("/greet") 
	public void generateWish2(Map<String, Object> map)
	{
		String res=service.generateGreeting();
		map.put("wish", res + " void return type");
		return;
	}
	
	//servlet code inside of controller
	@GetMapping("/servlet1")
	public void showResponse(HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Response coming from servlet method of controller</h1>");
	}
}
