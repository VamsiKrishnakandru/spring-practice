package com.tron.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tron.model.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {

}
