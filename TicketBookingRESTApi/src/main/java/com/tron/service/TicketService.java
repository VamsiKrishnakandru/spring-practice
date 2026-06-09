package com.tron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.model.Passenger;
import com.tron.model.Ticket;
import com.tron.repo.ITicketRepo;

@Service
public class TicketService implements ITicketService {

	@Autowired
	private ITicketRepo repo;
	
	@Override
	public int registerPassenger(Passenger passenger) {
		Passenger pass=repo.save(passenger);
		int ticketNumber = pass.getPid();
		return ticketNumber;
	}

	@Override
	public Ticket fetchTicket(int id) {
		Optional<Passenger> optional = repo.findById(id);
		Passenger pass = optional.get();
		Ticket ticket=new Ticket();
		ticket.setTicketNumber(pass.getPid());
		ticket.setName(pass.getName());
		ticket.setDeparture(pass.getDeparture());
		ticket.setArrival(pass.getArrival());
		ticket.setDateOfJourney(pass.getDateOfJourney());
		ticket.setStatus("Confirmed");
		ticket.setTicketPrice(4545.33);
		return ticket;
	}
}
