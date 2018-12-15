package com.microservices.SearchBarMicroservices.DataRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.SearchBarMicroservices.Model.Employee;

@Repository
@Transactional(readOnly = true)
public class SearchRepositoryImpl  {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Employee> getFirstNamesLike(String firstName) {
		// TODO Auto-generated method stub
		System.out.println(" First Name: "+ firstName);
		Query query = entityManager.createNativeQuery("SELECT em.* FROM employee as em " +
                "WHERE em.name LIKE ?", Employee.class);
        query.setParameter(1, firstName.toLowerCase() +"%");
        return query.getResultList();
	}
	public List<Employee> getEmpDetails() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("SELECT em.* FROM employee as em ", Employee.class);
        return query.getResultList();
	}

}
