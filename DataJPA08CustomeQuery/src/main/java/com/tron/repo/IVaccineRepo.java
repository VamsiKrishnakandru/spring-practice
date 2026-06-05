package com.tron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tron.model.Vaccine;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
//	@Query("FROM Vaccine WHERE vaccineCompany=:company")
//	public List<Vaccine> searchByVaccineCompany(String company);
	
	//Here the method parameter and variable in HQL are diff so use @Param
	@Query("FROM Vaccine WHERE vaccineCompany=:company")
	public List<Vaccine> searchByVaccineCompany(@Param("company") String c);
	
	@Query("FROM Vaccine WHERE vaccineCompany IN(:comp1, :comp2)")
	public List<Vaccine> searchByVaccineCompanies(String comp1, String comp2);
	
	@Query("SELECT vaccineName FROM Vaccine WHERE cost BETWEEN :minPrice AND :maxPrice")
	public List<String> searchByVaccineCost(Double minPrice, Double maxPrice);
	
	//For non Select operations need to use @Transactional annotation
	@Transactional
	@Modifying
	@Query("UPDATE Vaccine SET cost=:newCost WHERE vaccineName=:vaccineName")
	public int updateCostByVaccineName(Double newCost, String vaccineName);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Vaccine WHERE vaccineName=:vaccineName")
	public int deleteVaccineByVaccineName(String vaccineName);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO vaccine(`id`, `vaccine_name`, `vaccine_company`, `cost`) VALUES (?,?,?,?)", nativeQuery=true)
	public int insertVaccineInfo(Integer id, String vaccineName, String vaccineCompany, Double cost);
}
