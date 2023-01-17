package com.example.profiles.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.profiles.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>,PagingAndSortingRepository<Employee,Integer>{

	Iterable<Employee> findAll(Sort by);

	//void saveAll(List<Employee> asList);

	

	

}
