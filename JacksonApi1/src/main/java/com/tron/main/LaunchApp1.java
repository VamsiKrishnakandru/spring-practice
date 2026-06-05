package com.tron.main;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tron.model.Alien;

public class LaunchApp1 
{
	public static void main(String[] args) throws JsonProcessingException 
	{
		Alien alien1 = new Alien(1, "Tron", "Hyderabad");
		Alien alien2 = new Alien(2, "Tron", "Hyderabad");
		Alien alien3 = new Alien(3, "Tron", "Hyderabad");
		
		System.out.println(alien1);
		List<Alien> aliens = Arrays.asList(alien1, alien2, alien3);
		
		ObjectMapper mapper = new ObjectMapper();
		//String json = mapper.writeValueAsString(alien1);
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aliens);
		System.out.println(json);
	}
}
