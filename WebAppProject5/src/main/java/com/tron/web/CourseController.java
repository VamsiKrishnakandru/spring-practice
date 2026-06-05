package com.tron.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tron.model.Course;

@Controller
public class CourseController 
{
	@GetMapping("/course-info")
	public String getCourseInfo(Model model)
	{
		Course course = new Course(1, "AI DevOps with AWS", 8400.2);
		System.out.println(course);
		model.addAttribute("course", course);
		return "index";
	}
	
	@GetMapping("/books-info")
	public String getCourseDetails(Model model)
	{
		String booksName[]=new String[] {"Java", "Spring Boot", "DevOps"};
		model.addAttribute("books", booksName);
		return "book";
	}
}
