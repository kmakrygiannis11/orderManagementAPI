package com.order.management.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.order.management.entities.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

	public Optional<Employee> findByNickName(String nickname);

	@Query("SELECT e FROM Employee e WHERE e.registrationDate <= :registrationDate")
	public List<Employee> findRegisteredBeforeDate(@Param("registrationDate") Date registrationDate);

}
