package com.tron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Vaccine;
import com.tron.view.ResultView;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
	List<ResultView> findByCostLessThan(Double cost);
}
