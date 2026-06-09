package com.tron.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.tron.model.Passenger;
import com.tron.model.Ticket;

@Service
public class TicketService implements ITicketService {

	private String url = "http://localhost:8484/ticketbookingapi/get-ticketNumber";
	private String get_url = "http://localhost:8484/ticketbookingapi/get-ticket/{ticketNumber}";

	@Override
	public int registerPassenger(Passenger passenger) 
	{
		//RestTemplate
//		RestTemplate restTemplate=new RestTemplate();
//		ResponseEntity<Integer> response = restTemplate.postForEntity(url , passenger, Integer.class);
		
		//WebClient
		WebClient webClient=WebClient.create();
		Integer ticketNumber = webClient.post()
		.uri(url)
		.bodyValue(passenger)
		.retrieve()
		.bodyToMono(Integer.class)
		.block();
		return ticketNumber;
	}

	@Override
	public Ticket generateTicket(int ticketNumber) 
	{
		//RestTemplate or //WebClient
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Ticket> response = restTemplate.getForEntity(get_url , Ticket.class, ticketNumber);
		
		//WebClient
		WebClient webClient=WebClient.create();
		Ticket ticket=webClient.get()
				.uri(get_url, ticketNumber)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();
		return ticket;
	}

}
