package com.tron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.service.VaccineService;
import com.tron.view.ResultView2;

@SpringBootApplication
public class DataJpa01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(DataJpa01Application.class, args);
		
		VaccineService service = container.getBean(VaccineService.class);
		
//		service.searchByCostLessThan(50000.0, ResultView1.class)
//		.forEach(v->System.out.println(v.getVaccineName()));
		
		service.searchByCostLessThan(50000.0, ResultView2.class)
		.forEach(v->System.out.println(v.getVaccineCompany() + " "
				+ v.getVaccineName() + " " + v.getCost()));
	}
}
