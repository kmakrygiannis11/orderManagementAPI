package com.order.management.web;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entities.Employee;
import com.order.management.services.Employees;
import com.order.management.web.dto.EmployeeRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/employees", produces = "application/json")
public class EmployeesRestEndpoint {

	@Autowired
	private Employees service;

	@ApiOperation(value = "addEmployee")
	@PostMapping("/")
	public Employee addEmployee(@RequestBody EmployeeRequest request) throws EntityExistsException {
		return service.addEmployee(request.getName(), request.getSurname(), request.getNickName(), request.getRole());
	}

	@ApiOperation(value = "removeEmployee")
	@DeleteMapping("/{id}")
	public Employee removeEmployee(@PathVariable long id) throws EntityNotFoundException {
		return service.removeEmployee(id);
	}

	@ApiOperation(value = "updateEmployee")
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable long id, @RequestBody EmployeeRequest request)
			throws EntityNotFoundException {
		return service.updateEmployee(id, request.getName(), request.getSurname(), request.getNickName(),
				request.getRegistrationDate(), request.getRole());
	}

	@ApiOperation(value = "retrieveEmployee")
	@GetMapping("/{id}")
	public Optional<Employee> retrieveEmployee(@PathVariable long id) {
		return service.retrieveEmployee(id);
	}

	@ApiOperation(value = "retrieveAllEmployees")
	@GetMapping
	public List<Employee> retrieveAllEmployees() {
		return service.retrieveAllEmployees();
	}

}
