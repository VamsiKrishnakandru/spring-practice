package com.tron.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Vaccine;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
	public List<Vaccine> findByCost(Double cost);
	
	public List<Vaccine> findByCostLessThanEqual(Double cost);
	
	public List<Vaccine> findByCostBetween(Double minCost, Double maxCost);
	
	public List<Vaccine> findByVaccineCompany(String cName);
	
	public List<Vaccine> findByVaccineNameInAndCostBetween(Collection<String> names, Double minCost, Double maxCost);
}
