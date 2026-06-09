package com.tron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Passenger;

@Repository
public interface ITicketRepo extends JpaRepository<Passenger, Integer> {
}
