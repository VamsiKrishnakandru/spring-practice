package com.tron;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.service.VaccineService;

@SpringBootApplication
public class DataJpa01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(DataJpa01Application.class, args);
		
		VaccineService service = container.getBean(VaccineService.class);
		
		service.searchByCostLessThan(5000.0)
		.forEach(v->System.out.println(v.getVaccineName() + " "
				+ v.getVaccineCompany()));
	}
}
