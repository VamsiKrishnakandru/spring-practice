package com.tron.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Tron 
{
	private ICourse course;
	
	public Tron()
	{
		super();
		System.out.println("Tron bean created");
	}
	
	public Tron(ICourse course)
	{
		super();
		this.course = course;
	}
	
	@Autowired
	@Qualifier("devOpsCourse")
	public void setCourse(ICourse course)
	{
		this.course = course;
	}
	
	public boolean buyTheCourse(double amount)
	{
		return course.getTheCourse(amount);
	}
}
