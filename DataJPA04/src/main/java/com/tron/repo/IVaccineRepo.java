package com.tron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Vaccine;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
}
