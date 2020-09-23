
package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Employee_Table;
import com.main.service.UserCRUDService;

@RestController
public class UserCRUDController {

	@Autowired
	UserCRUDService userCRUDService;

	@GetMapping("/crud/users")
	public List<Employee_Table> retrieveAllEmployee() {
		return userCRUDService.getAllEmployeeDetails();
	}

}
