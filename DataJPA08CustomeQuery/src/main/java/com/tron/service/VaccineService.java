package com.tron.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.model.Vaccine;
import com.tron.repo.IVaccineRepo;

@Service
public class VaccineService implements IVaccineService 
{
	private IVaccineRepo repo;

	@Autowired
	public void setRepo(IVaccineRepo repo) 
	{
		this.repo = repo;
	}

	@Override
	public List<Vaccine> fetchByVaccineCompany(String c) {
		return repo.searchByVaccineCompany(c);
	}

	@Override
	public List<Vaccine> fetchByVaccineCompanies(String comp1, String comp2) {
		return repo.searchByVaccineCompanies(comp1, comp2);
	}

	@Override
	public List<String> fetchByVaccineCost(Double minPrice, Double maxPrice) 
	{
		return repo.searchByVaccineCost(minPrice, maxPrice);
	}

	@Override
	public int updateTheCostByVaccineName(Double newCost, String vaccineName) 
	{
		return repo.updateCostByVaccineName(newCost, vaccineName);
	}

	@Override
	public int deleteVaccineByVaccineName(String vaccineName) 
	{
		return repo.deleteVaccineByVaccineName(vaccineName);
	}

	@Override
	public int insertVaccineDetails(Integer id, String vaccineName, String vaccineCompany, Double cost) 
	{
		return repo.insertVaccineInfo(id, vaccineName, vaccineCompany, cost);
	}
}
