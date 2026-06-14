package com.tron.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tron.model.Customer;
import com.tron.service.KafkaService;

@RestController
public class CxRestController {
	
	@Autowired
	private KafkaService service;
	
	@PostMapping("/add-cx")
	public String addCx(@RequestBody Customer cx)
	{
		return service.addCxMsg(cx);
	}
}
