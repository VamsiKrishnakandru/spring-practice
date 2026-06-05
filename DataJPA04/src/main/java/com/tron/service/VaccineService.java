package com.tron.service;

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
	public Vaccine fetchVaccineById(Integer id) 
	{
		return repo.getReferenceById(id);
	}

	@Override
	public List<Vaccine> fetchByGivenVaccineInfo(Vaccine vac) 
	{
		Example<Vaccine> example = Example.of(vac);
		return repo.findAll(example);
	}

	@Override
	public String removeVaccinesByGivenIds(Iterable<Integer> ids) 
	{
		List<Vaccine> vaccines = repo.findAllById(ids);
		if(vaccines.size()!=0)
		{
			//deletes data in 1 DB hit
			repo.deleteAllByIdInBatch(ids);
			return "Vaccines Records Deleted for given ids";
		}
		return "Unable to delete records";
	}	
}
