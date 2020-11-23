package com.order.management.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.order.management.entities.Employee;
import com.order.management.repositories.EmployeeDAO;
import com.order.management.services.Employees;
import com.order.management.util.Constants.Role;

@Service("employees")
public class EmployeesImpl implements Employees {

	private static Logger log = LoggerFactory.getLogger(EmployeesImpl.class);

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Employee addEmployee(String name, String surname, String nickName, Role role) {

		log.info("START addEmployee: name={}", name);
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSurname(surname);
		employee.setNickName(nickName);
		employee.setRegistrationDate(new Date());
		employee.setRole(role);
		employeeDAO.saveAndFlush(employee);
		return employee;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Employee removeEmployee(long id) throws EntityNotFoundException {
		log.info("START removeEmployee: id={}", id);
		Optional<Employee> employee = employeeDAO.findById(id);
		if (!employee.isPresent()) {
			log.error("Employee with id {} does not exist", id);
			throw new EntityNotFoundException();
		}

		employeeDAO.delete(employee.get());
		return employee.get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void test() {

		Employee employee = new Employee();
		employee.setName("Yiannis");
		employee.setSurname("Simou");
		employee.setRegistrationDate(new Date());
		employee.setRole(Role.CASHIER);
		employeeDAO.saveAndFlush(employee);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Employee updateEmployee(long id, String name, String surname, String nickName, Date registrationDate,
			Role role) throws EntityNotFoundException {
		log.info("START updateEmployee: id={}", id);
		Optional<Employee> employeeOpt = employeeDAO.findById(id);
		if (!employeeOpt.isPresent()) {
			log.error("Employee with id {} does not exist", id);
			throw new EntityNotFoundException();
		}

		Employee employee = employeeOpt.get();
		employee.setName(name);
		employee.setSurname(surname);
		employee.setNickName(nickName);
		employee.setRegistrationDate(registrationDate);
		employee.setRole(role);
		employeeDAO.saveAndFlush(employee);
		return employee;
	}

	@Override
	public Optional<Employee> retrieveEmployee(long id) {
		log.debug("START retrieveEmployee: id={}", id);
		return employeeDAO.findById(id);
	}

	@Override
	public List<Employee> retrieveAllEmployees() {
		log.debug("START retrieveAllEmployees");
		return employeeDAO.findAll();
	}

}
