package com.tron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.model.cx.Customer;
import com.tron.model.pd.Product;
import com.tron.repo.cx.ICustomerRepo;
import com.tron.repo.pd.IProductRepo;

@Service
public class CustomerProductService implements ICustomerProductService {
	
	@Autowired
	private ICustomerRepo repo1;
	
	@Autowired
	private IProductRepo repo2;

	@Override
	public List<Customer> getAllCx() {
		return repo1.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		return repo2.findAll();
	}

}
