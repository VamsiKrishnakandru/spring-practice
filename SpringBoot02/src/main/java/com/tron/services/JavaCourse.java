package com.tron.services;

import org.springframework.stereotype.Service;

@Service
public class JavaCourse implements ICourse
{
	public boolean getTheCourse(double amount)
	{
		System.out.println("Java Course is purchased and amount paid is : "+ amount);
		return true;
	}
}
