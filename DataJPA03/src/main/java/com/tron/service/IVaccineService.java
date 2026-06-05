package com.tron.service;

import com.tron.model.Vaccine;

public interface IVaccineService 
{
	Iterable<Vaccine> fetchVaccineInfoBySorting(boolean status, String... properties);
	
	Iterable<Vaccine> fetchVaccineInfoByPagination(int phNo, int pgSize, boolean status, String... properties);
	
	void fetchVaccineInfoByPagination(int pgSize);
}
