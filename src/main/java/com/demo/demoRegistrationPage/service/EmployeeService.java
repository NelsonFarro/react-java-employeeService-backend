package com.demo.demoRegistrationPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demoRegistrationPage.entity.Employee;
import com.demo.demoRegistrationPage.repository.EmployeeRepo;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Iterable<Employee> listAll()
	{
		return this.employeeRepo.findAll();
	}
	
	public void saveOrUpdateEmployee(Employee emp)
	{
		employeeRepo.save(emp);
	}
	
	public Employee getEmployeeById(long id)
	{
		return employeeRepo.findById(id).get();
	}
	
	public void updateEmployee(Employee emp, int id)
	{
		employeeRepo.save(emp);
	}
	
	public void deleteEmployee(long id)
	{
		employeeRepo.deleteById(id);
	}
}
