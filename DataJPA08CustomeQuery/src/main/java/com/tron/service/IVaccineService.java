package com.tron.service;

import java.util.Collection;
import java.util.List;

import com.tron.model.Vaccine;

public interface IVaccineService 
{
	public List<Vaccine> fetchByVaccineCompany(String c);
	
	public List<Vaccine> fetchByVaccineCompanies(String comp1, String comp2);
	
	public List<String> fetchByVaccineCost(Double minPrice, Double maxPrice);
	
	public int updateTheCostByVaccineName(Double newCost, String vaccineName);
	
	public int deleteVaccineByVaccineName(String vaccineName);
	
	public int insertVaccineDetails(Integer id, String vaccineName, String vaccineCompany, Double cost);
}
