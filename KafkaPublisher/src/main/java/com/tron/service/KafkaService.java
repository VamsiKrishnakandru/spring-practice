package com.tron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tron.model.Customer;
import com.tron.util.AppConstants;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public String addCxMsg(Customer cx)
	{
		kafkaTemplate.send(AppConstants.TOPIC_NAME, cx);
		return "Customer data added in kafka server";
	}
}
