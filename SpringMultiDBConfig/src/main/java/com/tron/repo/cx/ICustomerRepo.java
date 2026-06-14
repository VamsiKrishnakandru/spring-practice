package com.tron.repo.cx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.cx.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
