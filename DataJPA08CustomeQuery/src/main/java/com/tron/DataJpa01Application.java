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
		
		service.fetchByVaccineCompany("AstraZenica")
		.forEach(v->System.out.println(v));
		
		service.fetchByVaccineCompanies("AstraZenica", "Phizer")
		.forEach(v->System.out.println(v));
		
		service.fetchByVaccineCost(3000.0, 4000.0)
		.forEach(v->System.out.println(v));
		
//		int rowsAffected = service.updateTheCostByVaccineName(4300.0, "Covaxin");
//		System.out.println("Rows Affected : " + rowsAffected);
		
//		int rowsAffected = service.deleteVaccineByVaccineName("Covaxin");
//		System.out.println("Rows Affected : " + rowsAffected);
		
		int rowsAffected = service.insertVaccineDetails(5, "AWS", "Telusko", 5000.0);
		System.out.println("Rows Affected : " + rowsAffected);
	}
}
