package com.tron.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Customer;

//below annotation is just for reading purpose and good practice
@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer> 
{
	
}
