package com.tron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.service.VaccineService;

@SpringBootApplication
public class DataJpa01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(DataJpa01Application.class, args);
		
		VaccineService service = container.getBean(VaccineService.class);
		
		//service.fetchVaccineInfoBySorting(true, "vaccineName").forEach(v->System.out.println(v));
		
//		service.fetchVaccineInfoByPagination(2, 1, true, "vaccineName")
//		.forEach(v->System.out.println(v));
		
		service.fetchVaccineInfoByPagination(1);
	}
}
