package com.demo.demoRegistrationPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demoRegistrationPage.entity.Employee;
import com.demo.demoRegistrationPage.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getall")
	public Iterable<Employee> getAllEmployees()
	{
		return employeeService.listAll();
	}
	
	@PostMapping(value = "/save")
	private long saveEmployee(@RequestBody Employee employees)
	{
		employeeService.saveOrUpdateEmployee(employees);
		return employees.getId();
	}
	
	@RequestMapping("/employee/{id}")
	private Employee getEmpoyee(@PathVariable(name="id") int employeeId)
	{
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PutMapping("/edit/{id}")
	private Employee update(@RequestBody Employee employee, @PathVariable int id)
	{
		employee.setId(id);
		employeeService.saveOrUpdateEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/delete/{id}")
	private void deleteEmployee(@PathVariable ("id") int id)
	{
		employeeService.deleteEmployee(id);
	}
}
