package com.tron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tron.model.Customer;
import com.tron.repo.ICustomerRepo;

@Component
public class DataJpaRunner implements CommandLineRunner 
{
	@Autowired
	private ICustomerRepo repo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		repo.save(new Customer(1, "Tron case", "Hyderabad"));
	}
}
