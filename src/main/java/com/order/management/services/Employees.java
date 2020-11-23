package com.order.management.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import com.order.management.entities.Employee;
import com.order.management.util.Constants.Role;

public interface Employees {

	public Employee removeEmployee(long id) throws EntityNotFoundException;

	public Employee updateEmployee(long id, String name, String surname, String nickname, Date registrationDate,
			Role role) throws EntityNotFoundException;

	public Optional<Employee> retrieveEmployee(long id);

	public List<Employee> retrieveAllEmployees();

	public Employee addEmployee(String name, String surname, String nickname, Role role) throws EntityExistsException;

	public void test();

}
