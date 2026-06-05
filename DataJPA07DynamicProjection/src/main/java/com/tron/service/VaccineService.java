package com.tron.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.model.Vaccine;
import com.tron.repo.IVaccineRepo;
import com.tron.view.View;

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
	public <T extends View> List<T> searchByCostLessThan(Double cost, Class<T> cls) 
	{
		return repo.findByCostLessThan(cost, cls);
	}
}
