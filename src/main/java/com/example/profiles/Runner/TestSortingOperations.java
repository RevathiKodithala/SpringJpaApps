package com.example.profiles.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.example.profiles.entity.Employee;
import com.example.profiles.repository.EmployeeRepository;
@Component
public class TestSortingOperations implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
	Iterable<Employee> list = repo.findAll();
	list.forEach(System.out::println);
	
	///----case-1 -- 1 column -- ASC order--------------
	//Iterable<Employee> list2  = repo.findAll(Sort.by("empSal")); // order by esal asc
	Iterable<Employee> list2  = repo.findAll(Sort.by(Direction.ASC,"empSal")); // order by esal asc
	list2.forEach(System.out::println);
	
	///----case-2 -- 1 column -- DESC order--------------
	Iterable<Employee> list3  = repo.findAll(Sort.by(Direction.DESC,"empSal")); // order by esal desc
	list3.forEach(System.out::println);
	
	///----case-3 -- n column -- SAME order--------------
	Iterable<Employee> list4  = repo.findAll(Sort.by(Direction.DESC,"empSal","empDept"));
	
		
	list4.forEach(System.out::println);
	
	///-------case4--- n columns -- Mixed Order -----------
	repo.findAll(
			Sort.by(Order.desc("empSal"),Order.asc("empDept"))
			//Sort.by(Order.asc("empSal"),Order.desc("empDept"))
			)
	.forEach(System.out::println);
	
	}

}
