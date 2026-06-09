package com.tron.service;

import com.tron.model.Passenger;
import com.tron.model.Ticket;

public interface ITicketService 
{
	int registerPassenger(Passenger passenger);
	
	Ticket fetchTicket(int id);
}
