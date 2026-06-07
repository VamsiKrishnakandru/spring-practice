package com.tron.service;

import com.tron.model.Student;

public interface IGreetingService 
{
	String generateGreeting();
	Boolean addStudent(Student stu);
}
