package com.main.model;

import java.util.Date;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	
	@Id
	@GeneratedValue
	public Integer id;
	public String name;
	
	@JsonFormat(pattern="MM-dd-yyyy")
	public Date DOB;
	
	public String country;
	
	protected User() {

	}
	
	public User(Integer id, String name, Date dOB, String country) {
		super();
		this.id = id;
		this.name = name;
		this.DOB = dOB;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", country=" + country + "]";
	}


	

}