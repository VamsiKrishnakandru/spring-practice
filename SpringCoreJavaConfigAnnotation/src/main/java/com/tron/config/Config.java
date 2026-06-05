package com.tron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.telusko"})
public class Config 
{
	@Bean
	public Password createPasswordObj()
	{
		Password pass = new Password("SHA");
		return pass;
	}
}
