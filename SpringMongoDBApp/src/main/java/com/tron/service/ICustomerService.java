package com.tron.service;

import java.util.List;

import com.tron.dto.CustomerDto;
import com.tron.model.Customer;

public interface ICustomerService 
{
	String registerCustomer(CustomerDto dto);
	
	List<Customer> findAllCustomers();
	
	String removeCustomerInfoById(String id);
}
