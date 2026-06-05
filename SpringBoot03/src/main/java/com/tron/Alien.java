package com.tron;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Alien 
{
	static
	{
		System.out.println("Alien static block");
	}
	{
		System.out.println("Java Init block");
	}
	public Alien()
	{
		System.out.println("Alien Bean created");
	}
	@PostConstruct
	public void init()
	{
		System.out.println("Init method");
	}
	public void disp()
	{
		System.out.println("Focus is key");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("Clean up logic");
	}
}
