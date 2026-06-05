package com.tron.service;

import java.util.Collection;
import java.util.List;

import com.tron.model.Vaccine;

public interface IVaccineService 
{
	public List<Vaccine> searchByCost(Double cost);
	
	public List<Vaccine> searchByCostLessThanEqual(Double cost);
	
	public List<Vaccine> searchByCostBetween(Double minCost, Double maxCost);
	
	public List<Vaccine> searchByVaccineCompany(String cName);
	
	public List<Vaccine> searchByVaccineNameInAndCostBetween(Collection<String> names, Double minCost, Double maxCost);
}
