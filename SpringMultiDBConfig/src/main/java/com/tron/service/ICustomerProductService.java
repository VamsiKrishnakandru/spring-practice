package com.tron.service;

import java.util.List;

import com.tron.model.cx.Customer;
import com.tron.model.pd.Product;

public interface ICustomerProductService {

	List<Customer> getAllCx();
	
	List<Product> getAllProducts();
}
