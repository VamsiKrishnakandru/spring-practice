package com.tron.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tron.model.Alien;

public class LaunchApp1 
{
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Alien alien = mapper.readValue(new File("json/sample.json"), Alien.class);
		System.out.println(alien);
	}
}
