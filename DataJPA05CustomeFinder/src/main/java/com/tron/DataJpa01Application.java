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
		
//		service.searchByCost(4534.2).forEach(v->System.out.println(v));
		
//		service.searchByCostLessThanEqual(4000.2).forEach(v->System.out.println(v));
		
//		service.searchByCostBetween(2500.0, 4000.0).forEach(v->System.out.println(v));
		
//		service.searchByVaccineCompany("AstraZenica").forEach(v->System.out.println(v));
		
		Collection<String> names = new HashSet<>();
		
		names.add("CovidShield");
		names.add("Covaxin");
		names.add("Moderana");
		
		service.searchByVaccineNameInAndCostBetween(names, 2500.0, 4500.0)
		.forEach(v->System.out.println(v));
	}
}
