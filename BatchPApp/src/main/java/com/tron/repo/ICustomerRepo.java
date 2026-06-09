package com.tron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
}
