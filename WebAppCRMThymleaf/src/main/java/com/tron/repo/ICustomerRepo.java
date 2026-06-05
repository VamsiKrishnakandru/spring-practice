package com.tron.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Customer;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
