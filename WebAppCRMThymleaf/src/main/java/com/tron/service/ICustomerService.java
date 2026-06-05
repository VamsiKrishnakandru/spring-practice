package com.tron.service;

import java.util.List;

import com.tron.model.Customer;

public interface ICustomerService 
{
	List<Customer> getCustomerInfo();
	void registerCustomer(Customer customer);
	Customer fetchCustomerById(Integer id);
	void deleteCxRecord(Integer id);
}
