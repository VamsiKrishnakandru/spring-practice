package com.tron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.model.Vaccine;
import com.tron.repo.IVaccineRepo;

@Service
public class VaccineService implements IVaccineService 
{
	@Autowired
	private IVaccineRepo repo;

	@Override
	public String registerVaccineDetails(Vaccine vaccine) 
	{
		//here save method returns vaccine data from DB
		Vaccine vac=repo.save(vaccine);
		return "Vaccine Info stored with id "+ vac.getId();
	}

	@Override
	public Iterable<Vaccine> registerMultipleVaccines(Iterable<Vaccine> vaccines) 
	{	
		return repo.saveAll(vaccines);
	}

	@Override
	public Long getCount() 
	{
		return repo.count();
	}

	@Override
	public Boolean checkAvailability(Integer id) 
	{
		return repo.existsById(id);
	}

	@Override
	public Iterable<Vaccine> fetchAllVaccines() 
	{
		return repo.findAll();
	}

	@Override
	public Iterable<Vaccine> fetchAllVaccinesByIds(Iterable<Integer> ids) 
	{
		return repo.findAllById(ids);
	}

	@Override
	public Optional<Vaccine> fetchVaccineById(Integer id) 
	{
		return repo.findById(id);
	}

	@Override
	public String removeVaccineById(Integer id) 
	{
		Optional<Vaccine> optional = repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "Vaccine Record with id " + id + " is deleted";
		}
		return "There is no vaccine with id " + id + " to delete";
	}

	@Override
	public String removeVaccineByObj(Vaccine obj) 
	{
		Integer id=obj.getId();
		Boolean status=repo.existsById(id);
		if(status)
		{
			repo.deleteById(id);
			return "Vaccine Record with id " + id + " is deleted";
		}
		return "There is no vaccine with id " + id + " to delete";
	}

	@Override
	public String removeVaccineByIds(List<Integer> ids) 
	{
		List<Vaccine> vaccines =(List<Vaccine>) repo.findAllById(ids);
		int count=vaccines.size();
		if(count>0)
		{
			repo.deleteAllById(ids);
			return "Vaccines are deleted from records";
		}
		return "Failed to delete Vaccine info";
	}
}
