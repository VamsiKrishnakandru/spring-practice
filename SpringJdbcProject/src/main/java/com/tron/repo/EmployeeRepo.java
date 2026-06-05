package com.tron.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tron.model.Employee;

@Repository
public class EmployeeRepo implements IEmployeeRepo {
	private static final String SQL_QUERY = "SELECT * FROM employee";

	@Autowired
	private DataSource dataSource;

	private List<Employee> employees = null;

	@Override
	public List<Employee> getEmployee() {
		try 
		{
			Connection connection = dataSource.getConnection();
			PreparedStatement pstm = connection.prepareStatement(SQL_QUERY);
			ResultSet rs = pstm.executeQuery();
			employees = new ArrayList<>();
			while (rs.next()) 
			{
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setCity(rs.getString(3));
				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

}
