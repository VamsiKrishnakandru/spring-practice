package com.tron.service;

import java.util.List;

import com.tron.model.Vaccine;

public interface IVaccineService 
{
	Vaccine fetchVaccineById(Integer id);
	
	List<Vaccine> fetchByGivenVaccineInfo(Vaccine vac);
	
	String removeVaccinesByGivenIds(Iterable<Integer> ids);
}
