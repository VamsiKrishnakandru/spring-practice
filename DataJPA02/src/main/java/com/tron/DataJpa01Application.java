package com.tron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tron.service.VaccineService;

@SpringBootApplication
public class DataJpa01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(DataJpa01Application.class, args);
		
		VaccineService service = container.getBean(VaccineService.class);
		
//		String status = service.registerVaccineDetails(new Vaccine("CovidShield", "AstraZenica", 4534.2));
//		System.out.println(status);
		
//		List<Vaccine> vaccines = new ArrayList<>();
//		vaccines.add(new Vaccine("Covaxin", "BharatBio", 4354.3));
//		vaccines.add(new Vaccine("Moderana", "Phizer", 3454.3));
//		vaccines.add(new Vaccine("Influenza", "Cipla", 2324.3));
//		
//		Iterable<Vaccine> vac = service.registerMultipleVaccines(vaccines);
//		Iterator<Vaccine> itr = vac.iterator();
//		while(itr.hasNext())
//			System.out.println(itr.next());
		
//		long count=service.getCount();
//		System.out.println("Number of Vaccine info : " + count);
		int id=2;
//		boolean status = service.checkAvailability(id);
//		if(status)
//			System.out.println("Vaccine with id " + id + " is available");
//		else
//			System.out.println("Vaccine with id " + id + " is unavailable");
		
//		service.fetchAllVaccines().forEach(v->System.out.println(v));
		
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(5);
		ids.add(6);
		
//		service.fetchAllVaccinesByIds(ids).forEach(v->System.out.println(v));
		
//		Optional<Vaccine> optional = service.fetchVaccineById(id);
//		if(optional.isPresent())
//			System.out.println(optional.get());
//		else
//			System.out.println("No Vaccine with id " + id);
		
//		String status = service.removeVaccineById(5);
//		System.out.println(status);
		
		String status = service.removeVaccineByIds(ids);
		System.out.println(status);
	}
}
