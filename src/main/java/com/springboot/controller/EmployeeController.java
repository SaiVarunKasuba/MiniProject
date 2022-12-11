package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create Employee RestApi
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	//build Get All Employee RestApi
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	//build Get Emploee By Id RestApi
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long empId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(empId), HttpStatus.OK);
	}
	//build update Employee RestApi
	@PutMapping("{id}")
	//http://localhost:8080/api/employees/1
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long empId,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, empId), HttpStatus.OK);
	}
	//build delete employee RestApi
	@DeleteMapping("{id}")
	//http://localhost:8080/api/employees/1
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long empId)
	{
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>("Employee Deleted Succesfully", HttpStatus.OK);
	}
	
}
