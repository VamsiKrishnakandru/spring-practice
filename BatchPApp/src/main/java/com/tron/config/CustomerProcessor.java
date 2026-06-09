package com.tron.config;

import org.springframework.batch.infrastructure.item.ItemProcessor;

import com.tron.model.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
	
	@Override
	public Customer process(Customer item) throws Exception {
		//logic to process the data //filter
		if("NJ".equalsIgnoreCase(item.getZipCode())) {
			return item;
		} else {
			return null;
		}
	}
}
