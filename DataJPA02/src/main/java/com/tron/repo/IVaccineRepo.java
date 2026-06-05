package com.tron.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Vaccine;

@Repository
public interface IVaccineRepo extends CrudRepository<Vaccine, Integer> 
{
}
