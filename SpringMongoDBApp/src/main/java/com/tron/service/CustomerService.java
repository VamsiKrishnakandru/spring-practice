package com.tron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.dto.CustomerDto;
import com.tron.model.Customer;
import com.tron.repo.ICustomerRepo;

@Service
public class CustomerService implements ICustomerService 
{
	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(CustomerDto dto) {
		Customer cx=new Customer();
		BeanUtils.copyProperties(dto, cx);
		Customer cxDoc = repo.save(cx);
		return "Customer Data stored in Mongo DB and Oject id is "+ cxDoc.getId();
	}

	@Override
	public List<Customer> findAllCustomers() {
		return repo.findAll();
	}

	@Override
	public String removeCustomerInfoById(String id) {
		Optional<Customer> optional = repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "Customer Record is deleted for the given id " + id;
		}
		return "There is no Customer with given id";
	}
}
