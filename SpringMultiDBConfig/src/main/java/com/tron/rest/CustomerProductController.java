package com.tron.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tron.model.cx.Customer;
import com.tron.model.pd.Product;
import com.tron.service.ICustomerProductService;

@RestController
public class CustomerProductController {
	
	private ICustomerProductService service;
	
	@GetMapping("/get-cx")
	public ResponseEntity<List> getAllCxInfo()
	{
		List<Customer> cx = service.getAllCx();
		return new ResponseEntity<List>(cx, HttpStatus.OK);
	}
	
	@GetMapping("/get-cx")
	public ResponseEntity<List> getAllProductInfo()
	{
		List<Product> pd = service.getAllProducts();
		return new ResponseEntity<List>(pd, HttpStatus.OK);
	}
}
