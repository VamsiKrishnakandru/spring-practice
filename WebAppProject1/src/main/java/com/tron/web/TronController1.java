package com.tron.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TronController1 
{
	//older implementation - @RM in spring boot 2
	@RequestMapping("/welcome")
	public ModelAndView displaySomeInfo()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello! Welcome to our first App");
		mav.setViewName("index");
		return mav;
	}
}
