package com.microservices.SearchBarMicroservices.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.SearchBarMicroservices.DataRepository.SearchRepository;
import com.microservices.SearchBarMicroservices.Model.Employee;

@RestController
public class SearchController {
	
	@Autowired
	private SearchRepository searchRepository;
	
	@GetMapping("/search")
	public List<Employee> getSearchResult(@RequestParam("key") String searchKey){
		List<Employee> empList = searchRepository.getFirstNamesLike(searchKey);
		return empList;
	}
	
	@GetMapping("/searchAll")
	public List<Employee> getAllResult(){
		//List<Employee> empList = searchRepository.findAll();
		List<Employee> empList = searchRepository.findAll();
		System.out.println(" emp list: "+ empList);
		return empList;
	}
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee){
		System.out.println(" saveing employee ... "+employee);
		searchRepository.save(employee);
		return "Saved Employee successfully ... ";
	}
}
