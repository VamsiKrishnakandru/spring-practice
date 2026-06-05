package com.tron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.model.Employee;
import com.tron.repo.EmployeeRepo;

@SpringBootApplication
public class SpringJdbcProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringJdbcProjectApplication.class, args);
		
		EmployeeRepo repo = container.getBean(EmployeeRepo.class);
		
		repo.getEmployee().forEach(e->System.out.println(e));
	}
}
