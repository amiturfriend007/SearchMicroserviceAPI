package com.microservices.SearchBarMicroservices.DataRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.SearchBarMicroservices.Model.Employee;

public interface SearchRepository extends JpaRepository<Employee, Long>,EmployeeRepositoryCustom {

}
