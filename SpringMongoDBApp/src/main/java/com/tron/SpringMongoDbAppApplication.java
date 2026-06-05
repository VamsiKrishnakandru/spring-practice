package com.tron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.dto.CustomerDto;
import com.tron.service.CustomerService;
import com.tron.util.IDGenerator;

@SpringBootApplication
public class SpringMongoDbAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringMongoDbAppApplication.class, args);
		
		CustomerService service = container.getBean(CustomerService.class);
		
		String id=IDGenerator.generateId();
		CustomerDto dto = new CustomerDto(id, 6, "Tony", "Hyderabad");
		String status = service.registerCustomer(dto);
		System.out.println(status);
		System.out.println("*******************************");
		service.findAllCustomers().forEach(c->System.out.println(c));
		System.out.println("*******************************");
		String dStatus = service.removeCustomerInfoById("0e2e75fa-b115-4e60-b6bc-516b87a11e94");
		System.out.println(dStatus);
	}

}
