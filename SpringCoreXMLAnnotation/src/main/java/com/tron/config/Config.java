package com.tron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//create beans in config classes
@Configuration
public class Config 
{
	//return type should be object to be used as bean
	@Bean
	public Password createPasswordObj()
	{
		Password pass = new Password("SHA");
		return pass;
	}
}
