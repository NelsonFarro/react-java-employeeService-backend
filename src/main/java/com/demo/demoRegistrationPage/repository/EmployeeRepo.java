package com.demo.demoRegistrationPage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoRegistrationPage.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>
{
	
}
