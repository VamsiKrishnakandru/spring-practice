package com.tron.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tron.model.Employee;

@Repository("repo")
public class EmployeeRepo implements IEmployeeRepo 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//private String sql = "INSERT INTO EMPLOYEE(id, name, city) VALUES (1,'Tron', 'Mumbai')";
	
    private String sql = "INSERT INTO EMPLOYEE(id,name,city) VALUES(?,?,?)"; 
	
	@Override
	public void input(Employee emp)
	{
		jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getCity());
	}
}
