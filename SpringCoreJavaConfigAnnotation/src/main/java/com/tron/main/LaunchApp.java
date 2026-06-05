package com.tron.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tron.config.Config;
import com.tron.config.Password;

public class LaunchApp {

	public static void main(String[] args) 
	{
		ApplicationContext container = 
				new AnnotationConfigApplicationContext(Config.class);
		
		Password p = container.getBean(Password.class);
		System.out.println("Algo is used is " + p.getAlgo() );
	}
}
