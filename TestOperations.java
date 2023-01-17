package com.example.profiles.Test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.profiles.entity.Book;
import com.example.profiles.exception.BookNotFoundException;
import com.example.profiles.repository.BookRepository;

@Component
public class TestOperations implements CommandLineRunner{
	
	@Autowired
	private BookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book(10, "Core Java", "SAM", 200.0);
		repo.save(b1);
		
		repo.save(new Book(11, "Adv Java", "SYED", 300.0));
		repo.save(new Book(12, "Spring", "SAM", 400.0)); //INSERT
		repo.save(new Book(12, "Spring 6.x", "SAM", 600.0)); //UPDATE
		
		
		repo.saveAll(
				Arrays.asList(
						new Book(13, "HTML CSS", "AJAY", 100.0),
						new Book(14, "Bootstrap", "AJAY", 200.0),
						new Book(15, "ReactJS", "AJAY", 300.0)
						)
				);
		Iterable<Book> data = repo.findAll();
		//data.forEach(System.out::println);
		data.forEach(b->System.out.println(b));
		
		System.out.println(repo.count());
		
		System.out.println(repo.existsById(13));
		Book b4 = repo.findById(14).orElseThrow(
				() -> new BookNotFoundException("BOOK NOT EXIST WITH ID "));
		System.out.println(b4);
		repo.deleteById(15);
		
	}
	
}

