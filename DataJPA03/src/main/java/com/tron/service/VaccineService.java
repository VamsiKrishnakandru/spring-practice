package com.tron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public Iterable<Vaccine> fetchVaccineInfoBySorting(boolean status, String... properties) 
	{
		Sort sort = Sort.by(status?Direction.ASC:Direction.DESC, properties);
		return repo.findAll(sort);
	}

	@Override
	public Iterable<Vaccine> fetchVaccineInfoByPagination(int pgNo, int pgSize, boolean status, String... properties) 
	{
		PageRequest pageable = PageRequest.of(pgNo, pgSize, status?Direction.ASC:Direction.DESC, properties);
		Page<Vaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchVaccineInfoByPagination(int pgSize) 
	{
		long count = 5l;
		long pageCount = count/pgSize;
		pageCount=count%pgSize==0?pageCount:++pageCount;
		for(int i=0; i<pageCount; i++)
		{
			PageRequest pageable = PageRequest.of(i, pgSize);
			Page<Vaccine> page = repo.findAll(pageable);
			page.getContent().forEach(v->System.out.println(v));
			System.out.println("*******************************");
		}
		return ;
	}	
}
