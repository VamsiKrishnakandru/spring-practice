package com.tron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Vaccine;
import com.tron.view.View;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
	public <T extends View>List<T> findByCostLessThan(Double cost, Class<T> cls);
}
