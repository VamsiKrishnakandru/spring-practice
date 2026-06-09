package com.tron.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tron.model.Passenger;
import com.tron.model.Ticket;
import com.tron.service.ITicketService;

@Controller
public class TicketController 
{
	@Autowired
	private ITicketService service;
	
	@GetMapping("/get-form")
	public String getForm(@ModelAttribute Passenger passenger, Model model)
	{
		return "index";
	}
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute Passenger passenger, Model model)
	{
		int ticketNumber = service.registerPassenger(passenger);
		//int ticketNumber = 45445;
		model.addAttribute("ticketNumber", ticketNumber);
		return "index";
	}
	
	@GetMapping("/ticket-form")
	public String getTicketForm(@ModelAttribute Passenger passenger, Model model)
	{
		return "ticket-form";
	}
	
	@GetMapping("/get-ticket")
	public String getTicketForm(@RequestParam("ticketNumber") int ticketNumber, Model model)
	{
		Ticket ticket = service.generateTicket(ticketNumber);
		//Ticket ticket = new Ticket(45454, "Confirmed", 5454.32, "Tron", "Hyderabad", "Pune", "24th July");
		model.addAttribute("ticket", ticket);
		return "ticket-info";
	}
}
