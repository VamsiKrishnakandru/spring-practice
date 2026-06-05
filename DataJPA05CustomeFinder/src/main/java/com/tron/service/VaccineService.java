package com.tron.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public List<Vaccine> searchByCost(Double cost) 
	{
		return repo.findByCost(cost);
	}

	@Override
	public List<Vaccine> searchByCostLessThanEqual(Double cost) 
	{
		return repo.findByCostLessThanEqual(cost);
	}

	@Override
	public List<Vaccine> searchByCostBetween(Double minCost, Double maxCost)
	{
		return repo.findByCostBetween(minCost, maxCost);
	}

	@Override
	public List<Vaccine> searchByVaccineCompany(String cName) 
	{
		return repo.findByVaccineCompany(cName);
	}

	@Override
	public List<Vaccine> searchByVaccineNameInAndCostBetween(Collection<String> names, Double minCost, Double maxCost) 
	{
		return repo.findByVaccineNameInAndCostBetween(names, minCost, maxCost);
	}
}
