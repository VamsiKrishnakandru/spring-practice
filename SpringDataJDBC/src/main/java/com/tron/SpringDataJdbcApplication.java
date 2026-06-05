package com.tron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.model.Employee;
import com.tron.repo.EmployeeRepo;

@SpringBootApplication
public class SpringDataJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJdbcApplication.class, args);
		
//		Employee emp = new Employee(1, "Sameer", "Hyderabad");
//		
//		EmployeeRepo repo = container.getBean(EmployeeRepo.class);
//		repo.input(emp);
//		System.out.println("Check DB");
	}
}
