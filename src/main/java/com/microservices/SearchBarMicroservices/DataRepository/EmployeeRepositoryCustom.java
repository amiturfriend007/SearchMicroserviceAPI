package com.microservices.SearchBarMicroservices.DataRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservices.SearchBarMicroservices.Model.Employee;

public interface EmployeeRepositoryCustom {
	
	@Query("SELECT em FROM Employee em WHERE UPPER(em.name) LIKE CONCAT(UPPER(:firstName),'%')")
	List<Employee> getFirstNamesLike(@Param("firstName") String firstName);
	List<Employee> getEmpDetails(); 
}
