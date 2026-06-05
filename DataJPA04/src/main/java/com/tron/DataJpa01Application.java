package com.tron;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.service.VaccineService;

@SpringBootApplication
public class DataJpa01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(DataJpa01Application.class, args);
		
		VaccineService service = container.getBean(VaccineService.class);
		
//		Vaccine v = service.fetchVaccineById(2);
//		System.out.println(v);
		
//		service.fetchByGivenVaccineInfo(new Vaccine("Covaxin", "BharatBio", 4354.3))
//		.forEach(vac->System.out.println(vac));
		
		ArrayList<Integer> ids = new ArrayList<>();
		ids.add(2);
		String status = service.removeVaccinesByGivenIds(ids);
		System.out.println(status);
	}
}
