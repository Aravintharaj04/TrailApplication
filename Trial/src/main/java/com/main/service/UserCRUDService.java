
package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Employee_Table;
import com.main.repository.EmployeeRepository;

@Service
public class UserCRUDService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee_Table> getAllEmployeeDetails() {
		return (List<Employee_Table>) employeeRepository.findAll();
	}
	
	public Optional<Employee_Table> getAllEmployeeDetailsbyID(Long id) {
		Optional<Employee_Table> employee=  employeeRepository.findById(id);
		return employee;
	}


	
}
