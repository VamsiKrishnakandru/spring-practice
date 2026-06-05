package com.tron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.service.Greetings;

@SpringBootApplication
public class SpringBootWebDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringBootWebDemoApplication.class, args);
		
		Greetings service = container.getBean(Greetings.class);
		
		System.out.println(service.generateGreetings("Saurabh"));
	}

}
