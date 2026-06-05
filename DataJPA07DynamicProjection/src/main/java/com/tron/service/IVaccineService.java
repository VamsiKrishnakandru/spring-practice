package com.tron.service;

import java.util.Collection;
import java.util.List;

import com.tron.model.Vaccine;
import com.tron.view.View;

public interface IVaccineService 
{
	public <T extends View>List<T> searchByCostLessThan(Double cost, Class<T> cls);
}
