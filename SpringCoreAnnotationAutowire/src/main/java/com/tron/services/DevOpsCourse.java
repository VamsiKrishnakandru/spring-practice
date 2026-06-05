package com.tron.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary 
public class DevOpsCourse implements ICourse 
{
	public boolean getTheCourse(double amount)
	{
		System.out.println("DevOps Course is purchased and amount paid is : "+ amount);
		return true;
	}
}
