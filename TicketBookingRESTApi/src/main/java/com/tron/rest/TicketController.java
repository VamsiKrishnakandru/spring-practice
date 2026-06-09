package com.tron.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tron.model.Passenger;
import com.tron.model.Ticket;
import com.tron.service.ITicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Ticket Booking API Controller", description="This API will store passenger info and generate ticket")
public class TicketController {
	
	@Autowired
	private ITicketService service;
	
	@PostMapping("/get-ticketNumber")
	@Operation(summary="POST Operation", description="This API method will receive Passenger type data and generate ticket number")
	public ResponseEntity<Integer> generateTicketNumber(@RequestBody Passenger passenger)
	{
		int ticketNumber = service.registerPassenger(passenger);
		return new ResponseEntity<Integer>(ticketNumber, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-ticket/{ticketNumber}")
	@Operation(summary="GET Operation", description="This API method will accept ticket number and generate Full ticket")
	public ResponseEntity<Ticket> generateTicket(@PathVariable("ticketNumber") int ticketNumber)
	{
		Ticket ticket = service.fetchTicket(ticketNumber);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
}
