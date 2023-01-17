package com.example.profiles.Runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.profiles.entity.Employee;
import com.example.profiles.repository.EmployeeRepository;

@Component
public class TestSaveOperations implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.saveAll(
				//List.of(
				Arrays.asList(
						new Employee(10, "AAB", 200.0, "DEV"),
						new Employee(11, "AAB", 200.0, "QA"),
						new Employee(12, "AAB", 200.0, "BA"),
						new Employee(13, "AAB", 300.0, "DEV"),
						new Employee(14, "AAB", 300.0, "QA"),
						new Employee(15, "AAB", 300.0, "BA"),
						new Employee(16, "AAB", 400.0, "DEV"),
						new Employee(17, "AAB", 400.0, "QA"),
						new Employee(18, "AAB", 400.0, "BA")
						)
				);
		
		
	}

}
