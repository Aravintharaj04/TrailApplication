
package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.main.model.Employee_Table;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee_Table, Long> {

}
