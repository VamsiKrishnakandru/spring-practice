package com.tron.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tron.model.Vaccine;
import com.tron.repo.IVaccineRepo;
import com.tron.view.ResultView;

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
	public List<ResultView> searchByCostLessThan(Double cost) 
	{
		return repo.findByCostLessThan(cost);
	}
}
