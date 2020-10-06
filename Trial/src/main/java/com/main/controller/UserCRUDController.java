
package com.main.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.main.exceptions.UserNotFoundException;
import com.main.model.Employee_Table;
import com.main.repository.EmployeeRepository;
import com.main.service.UserCRUDService;

@RestController
public class UserCRUDController {

	@Autowired
	UserCRUDService userCRUDService;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/jpa/users")
	public ResponseEntity<Object> retrieveAllEmployee() {
		List<Employee_Table> emp= userCRUDService.getAllEmployeeDetails();
		if(emp.isEmpty()) {
			throw new UserNotFoundException("No Data found");
		}
		return new ResponseEntity<Object>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/jpa/empById/{id}")
	public ResponseEntity<Object> retrieveEmployeeById(@PathVariable Long id ) {
		Optional<Employee_Table> employee= userCRUDService.getAllEmployeeDetailsbyID(id);
		
		if(!employee.isPresent()) {
			throw new UserNotFoundException("User not found for the ID");
		}else {
			return new ResponseEntity<Object>(employee,HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/jpa/emp/save")
	public ResponseEntity<Object> createUser(@RequestBody Employee_Table emp) {
		Employee_Table savedemp = employeeRepository.save(emp);
		
		String empName= savedemp.getEmpName();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedemp.getId())
				.toUri();
		if(savedemp!=null)
			return new ResponseEntity<Object>(empName+" Added to DB",HttpStatus.CREATED);
		else {
			throw new UserNotFoundException("Data Not saved");
		}

	}
	
	@DeleteMapping("/jpa/empDelete/{id}")
	public void deleteUser(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}

}
