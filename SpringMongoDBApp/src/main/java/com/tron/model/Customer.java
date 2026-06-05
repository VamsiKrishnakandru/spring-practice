package com.tron.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer 
{
	@Id
	private String id;
	
	private Integer cusNum;
	
	private String name;
	
	private String city;

	public Customer() {
		super();
	}

	public Customer(String id, Integer cusNum, String name, String city) {
		super();
		this.id = id;
		this.cusNum = cusNum;
		this.name = name;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCusNum() {
		return cusNum;
	}

	public void setCusNum(Integer cusNum) {
		this.cusNum = cusNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", cusNum=" + cusNum + ", name=" + name + ", city=" + city + "]";
	}
}
