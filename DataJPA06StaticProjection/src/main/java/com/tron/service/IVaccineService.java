package com.tron.service;

import java.util.Collection;
import java.util.List;

import com.tron.model.Vaccine;
import com.tron.view.ResultView;

public interface IVaccineService 
{
	List<ResultView> searchByCostLessThan(Double cost);
}
