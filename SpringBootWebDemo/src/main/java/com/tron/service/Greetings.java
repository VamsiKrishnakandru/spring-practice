package com.tron.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Greetings implements IGreetingsService
{
	@Autowired
	private LocalTime time;
	
	public Greetings()
	{
		System.out.println("Greetings bean created");
	}
	
	public String generateGreetings(String name)
	{
		int hour = time.getHour();
		if(hour<12)
			return "Good Morning " + name;
		else if(hour<16)
			return "Good Afternoon " + name;
		else if(hour<20)
			return "Good Evening " + name;
		else
			return "Good Night " + name;
	}
}
