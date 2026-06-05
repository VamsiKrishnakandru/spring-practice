package com.tron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tron.model.Employee;
import com.tron.repo.IEmployeeRepo;

@Component
public class JdbcRunner implements CommandLineRunner 
{
	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		repo.input(new Employee(1, "Ram", "Chennai"));
	}
}
