package com.tron.services;

import org.springframework.stereotype.Service;

@Service
public class DevOpsCourse implements ICourse 
{
	public boolean getTheCourse(double amount)
	{
		System.out.println("DevOps Course is purchased and amount paid is : "+ amount);
		return true;
	}
}
