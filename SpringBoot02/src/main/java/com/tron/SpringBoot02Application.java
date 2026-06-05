package com.tron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.services.Tron;

@SpringBootApplication
public class SpringBoot02Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringBoot02Application.class, args);
		
		Tron tron = container.getBean(Tron.class);
		
		boolean status = tron.buyTheCourse(4545.54);
		if(status)
			System.out.println("Enrolled to Course");
		else
			System.out.println("Failed to enroll");
	}

}
