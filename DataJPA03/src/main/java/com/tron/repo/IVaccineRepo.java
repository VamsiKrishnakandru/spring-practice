package com.tron.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Vaccine;

@Repository
public interface IVaccineRepo extends PagingAndSortingRepository<Vaccine, Integer> 
{
}
