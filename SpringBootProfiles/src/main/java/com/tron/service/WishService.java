package com.tron.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("wish")
public class WishService implements IGreetingService {
	
	public WishService()
	{
		System.out.println("wish service is created");
	}

	@Autowired
	private LocalTime time;
	
	@Override
	public String generateGreeting() 
	{
		int hour = time.getHour();
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good Afternoon";
		else if(hour<20)
			return "Good Evening";
		else 
			return "Good Night";
	}
}
