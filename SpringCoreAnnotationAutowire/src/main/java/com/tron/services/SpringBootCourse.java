package com.tron.services;

import org.springframework.stereotype.Service;

@Service
public class SpringBootCourse implements ICourse 
{
	public boolean getTheCourse(double amount)
	{
		System.out.println("SpringBoot Course is purchased and amount paid is : "+ amount);
		return true;
	}
}
