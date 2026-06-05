package com.tron.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Tron 
{
	//field injection
	//@Autowired
	//@Qualifier("springBootCourse")
	private ICourse course;
	
	public Tron()
	{
	}
	
	//constructor injection
	//Qualifier annotation does not work with constructors
	//Go with parameter annotation here
	@Autowired
	public Tron(@Qualifier("javaCourse")ICourse course)
	{
		super();
		this.course = course;
	}
	
	//setter injection using autowire
	//@Autowired
	//@Qualifier("springBootCourse")
	public void setCourse(ICourse course)
	{
		this.course = course;
	}
	
	public boolean buyTheCourse(double amount)
	{
		return course.getTheCourse(amount);
	}
}
